package cn.springboot.blog.service;

import cn.springboot.blog.entity.LetterAndUser;
import cn.springboot.blog.entity.PrivateLetters;
import java.util.*;
public interface PrivateLetterService {

    /**
    *@author 吕杨平
    *@Description 发送消息
    *@Date 11:14 2023/2/20
    *@Param [privateLetters]
    *@Return int
    */
    PrivateLetters sendMessage(PrivateLetters privateLetters);


    /**
    *@author 吕杨平
    *@Description 撤回消息
    *@Date 11:15 2023/2/20
    *@Param
    *@Return
    */
    boolean retractMessage(Integer lid);

    /**
    *@author 吕杨平
    *@Description 获取消息
    *@Date 11:14 2023/2/20
    *@Param [fromUid, toUid]
    *@Return java.util.List<cn.springboot.blog.entity.LetterAndUser>
    */
    Map<Date,List<LetterAndUser>> getUserMessage(Integer fromUid,Integer toUid);
}
