package cn.springboot.blog.api.blog;


import cn.springboot.blog.entity.ConnectList;
import cn.springboot.blog.entity.LetterAndUser;
import cn.springboot.blog.service.ConnectListService;
import cn.springboot.blog.service.PrivateLetterService;
import cn.springboot.blog.socket.webSocket;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "v1", tags = "用户私信接口")
@RequestMapping("/api/v1")
public class PrivateLetterApi {
    @Autowired
    PrivateLetterService privateLetterService;

    @Autowired
    ConnectListService connectListService;


    @Resource
    webSocket webSocket;

    @GetMapping("/message/UserMessages")
    public Result UserMessages(@RequestParam @ApiParam(value = "发送者id") Integer fromUid,
                               @RequestParam  @ApiParam(value = "接收者id") Integer toUid,
                               @RequestParam @ApiParam(value = "重置id") Integer connectId){
        try {
            Map<Date, List<LetterAndUser>> userMessage = privateLetterService.getUserMessage(fromUid, toUid);
            //            已读内容 清空用户间的聊天connect_list信息
            connectListService.updateConnectList(new ConnectList(connectId,null,null,null,new Date(),null,null,"reset"));
            return ResultGenerator.genSuccessResult(userMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}
