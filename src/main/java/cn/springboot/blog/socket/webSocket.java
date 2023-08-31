package cn.springboot.blog.socket;

import javax.annotation.PostConstruct;
import javax.websocket.Session;

import cn.springboot.blog.entity.ConnectList;
import cn.springboot.blog.entity.PrivateLetters;
import cn.springboot.blog.entity.UserInfo;
import cn.springboot.blog.entity.UserInfoAndRegisterInfo;
import cn.springboot.blog.service.*;
import cn.springboot.blog.service.impl.PrivateLetterServiceImpl;
import cn.springboot.blog.util.SocketUtil;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/socket/{userId}")
public class webSocket{
    @Autowired
    PrivateLetterService privateLetterService;

    @Autowired
    ConnectListService connectListService;

    @Autowired
    MallUserService mallUserService;

    @Autowired
    UserFansService userFansService;

    static webSocket Socket;


    @PostConstruct
    public  void init(){
        Socket = this;
    }
    Session session;

    Integer userId;

    static Map<Integer,Session>  sessionPool= new ConcurrentHashMap<>();

    static CopyOnWriteArrayList<webSocket> webSockets = new CopyOnWriteArrayList<>();


    @OnOpen
    public void onOpen(Session session,@PathParam(value="userId")Integer userId){
        sessionPool.put(userId,session);
        this.session = session;
        this.userId = userId;
        webSockets.add(this);
        try{
            Map<String,Object> newUserLoginInfo = SocketUtil.getSystemMessageMap("系统提示");
            newUserLoginInfo.put("cmd","newUserLogin");
            UserInfoAndRegisterInfo userInfo = Socket.mallUserService.selectUserInfoById(Long.valueOf(userId));
            newUserLoginInfo.put("newUserInfo",userInfo);
            System.out.println(newUserLoginInfo);
            sendAllMessage(newUserLoginInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        try {
            sessionPool.remove(this.userId);
            webSockets.remove(this);
            Map<String,Object> newUserLoginInfo = SocketUtil.getSystemMessageMap("系统提示");
            newUserLoginInfo.put("cmd","newUserLoginOut");
            UserInfoAndRegisterInfo userInfo = Socket.mallUserService.selectUserInfoById(Long.valueOf(userId));
            newUserLoginInfo.put("newUserInfo",userInfo);
            sendAllMessage(newUserLoginInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session,Throwable err){
        err.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message){
        JSONObject info = JSONObject.parseObject(message);
//        接收指令
        String cmd = info.getString("cmd");
//        发送方用户id
        Integer fromUid = info.getInteger("fromUid");
//        发送其他用户消息
        if("send".equals(cmd)) {
            try {
                String content = info.getString("content");
                Date date = new Date(info.getLong("sendTime"));
//                接收方uid
                Integer toUid = info.getInteger("toId");
                PrivateLetters privateLetters = new PrivateLetters(content, date, fromUid, toUid);
                Socket.privateLetterService.sendMessage(privateLetters);
                System.err.println(info);
                Map<String, Object> map = new HashMap<>();
//                插入成功
                if (privateLetters.getLid() != null) {
                    map.put("data", message);
                    map.put("cmd", "add");
                    map.put("fromUid",fromUid);
                    map.put("toUid",toUid);
//                    发送的用户在线
                    if(sessionPool.containsKey(toUid)) {
                        //                    向其他用户发送消息
                        sendOneMessage(new JSONObject(map).toString(), toUid);
                    }else{
                        Integer connectId = Socket.connectListService.selectConnectIdByPrincipalAndSubordinate(toUid,fromUid);
                        System.err.println(connectId);
//                        没有聊天记录
                        if(connectId==null){
                            ConnectList insertConnectList = Socket.connectListService.insertConnectList(new ConnectList(connectId, toUid, fromUid, 0, new Date(), content, 1,null));
                            if(insertConnectList==null){
                                System.err.println("插入失败");
                            }else{
                                connectId = insertConnectList.getConnectId();
                            }
                        }else {
                            Socket.connectListService.updateConnectList(new ConnectList(connectId, toUid, fromUid, 0, new Date(), content, 1,"+"));
                        }
                    }
                    map.put("cmd", "rep");
                    map.put("message", "发送成功");
                    map.put("time", date.getTime());
                    sendOneMessage(new JSONObject(map).toString(), fromUid);
                } else {
                    map.put("message", "发送失败");
                    sendOneMessage(new JSONObject(map).toString(), fromUid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        寻找在线状态
        else if("search".equals(cmd)){
            Map<String,Object> map = new HashMap<>();
            try {
                Integer[] userIds = info.getJSONArray("userIds").toArray(Integer.class);
                System.out.println(Arrays.toString(userIds));
                map.put("onlineStatus",judgeUserListOnline(userIds));
                System.out.println(judgeUserListOnline(userIds));
                map.put("message","发送成功");
                map.put("cmd","search");
                sendOneMessage(new JSONObject(map).toString(),fromUid);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sendOneMessage(String message,Integer userId){
        Session target = sessionPool.get(userId);
        System.out.println(sessionPool);
        System.err.println(userId+" "+message+" "+target);
        if(target!=null&&target.isOpen()){
            try {
                target.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void sendAllMessage(Map<String,Object> message){
        for(webSocket webSocket:webSockets){
            if(webSocket.session.isOpen()){
                try {
                    message.put("fanEach",Socket.userFansService.fanEachOther(webSocket.userId,this.userId,2)==2);
                    webSocket.session.getAsyncRemote().sendText(new JSONObject(message).toJSONString());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public boolean judgeUserOnline(Integer userId){
        for(webSocket webSocket:webSockets){
            if(Objects.equals(webSocket.userId, userId)){
                return true;
            }
        }
        return false;
    }

    public Map<String,Boolean> judgeUserListOnline(Integer[] userIds){
        Map<String,Boolean> map = new HashMap<>();

        for (Integer id : userIds) {
            map.put(id.toString(), judgeUserOnline(id));
        }

        return map;
    }
}
