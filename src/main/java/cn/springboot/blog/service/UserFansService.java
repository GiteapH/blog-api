package cn.springboot.blog.service;

import cn.springboot.blog.entity.UserAndFanned;
import cn.springboot.blog.entity.UserFan;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.Result;

import java.util.*;

public interface UserFansService {
    Result addFan(Integer upUid, Integer loginUid, Byte type);

//    返回关注类型
    UserFan checkLoginUserIsFan(Integer upUid, Integer loginUid);

    int getUserFanLen(Integer loginUid,Integer type);

    int getUserFanListLen(Integer loginUid);

    int updateUserFan(UserFan userFan);


    int fanEachOther(Integer upUid, Integer loginUid,Integer type );

    List<UserAndFanned> getAllUserFanned(PageQueryUtil pageQueryUtil);

//    粉丝列表
    List<UserAndFanned> getAllUserFansList(PageQueryUtil pageQueryUtil);

    int delFan(Integer fid);
}
