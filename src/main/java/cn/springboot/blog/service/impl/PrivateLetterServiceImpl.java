package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.ArticlesMapper;
import cn.springboot.blog.dao.PrivateLettersMapper;
import cn.springboot.blog.dao.UsersMapper;
import cn.springboot.blog.entity.Articles;
import cn.springboot.blog.entity.LetterAndUser;
import cn.springboot.blog.entity.PrivateLetters;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.service.PrivateLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

@Service
public class PrivateLetterServiceImpl implements PrivateLetterService {
    @Autowired
    PrivateLettersMapper privateLettersMapper;
    @Autowired
    ArticlesMapper articlesMapper;

    /**
     * @param privateLetters
     * @author 吕杨平
     * @Description 发送消息
     * @Date 11:14 2023/2/20
     * @Param [privateLetters]
     * @Return int
     */
    @Override
    public PrivateLetters sendMessage(PrivateLetters privateLetters) {
        int rows = privateLettersMapper.insertSelective(privateLetters);
        if(rows!=1){
            return null;
        }
        return privateLetters;
    }

    /**
     * @param lid
     * @author 吕杨平
     * @Description 撤回消息
     * @Date 11:15 2023/2/20
     * @Param
     * @Return
     */
    @Override
    public boolean retractMessage(Integer lid) {
        return privateLettersMapper.deleteByPrimaryKey(lid)==1;
    }

    /**
     * @param fromUid
     * @param toUid
     * @author 吕杨平
     * @Description 获取消息
     * @Date 11:14 2023/2/20
     * @Param [fromUid, toUid]
     * @Return java.util.List<cn.springboot.blog.entity.LetterAndUser>
     */
    @Override
    public Map<Date,List<LetterAndUser>> getUserMessage(Integer fromUid, Integer toUid) {
        List<LetterAndUser> messages = privateLettersMapper.selectAllLetters(fromUid, toUid);
        Map<Date,List<LetterAndUser>> dateStore = new LinkedHashMap<>();
        long start;
        if(messages.size()>0) {
            start = messages.get(0).getSendTime().getTime();
            dateStore.put(messages.get(0).getSendTime(),new ArrayList<>());
            for(LetterAndUser letterAndUser:messages){
//                处理数据
                letterAndUser.setSender(Objects.equals(fromUid, letterAndUser.getFromUid()));
//                如果属于自动推送
                if(letterAndUser.getIsPush()==1 && !Objects.equals(fromUid, letterAndUser.getFromUid())){
                    switch (letterAndUser.getPushTable()){
                        case "articles":{
                            Articles articles = articlesMapper.selectArticlesByPrimaryKey(letterAndUser.getPushId());
                            letterAndUser.setPushContent(articles);
                            break;
                        }
//                        多余的
                        case "other":{

                        }
                        default:{
                            break;
                        }
                    }
                }

                long curTime = letterAndUser.getSendTime().getTime();
//                两分钟以内的评论放一起
                if(curTime-2*60*1000<start){
                    dateStore.get(new Date(start)).add(letterAndUser);
                }else{
                    start = curTime;
                    List<LetterAndUser> letterAndUsers = new ArrayList<>();
                    letterAndUsers.add(letterAndUser);
                    dateStore.put(new Date(curTime),letterAndUsers);
                }
            }
        }
        return dateStore;
    }
}
