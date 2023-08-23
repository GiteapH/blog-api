package cn.springboot.blog.service;

import cn.springboot.blog.api.blog.param.updateUserInfoParams;
import cn.springboot.blog.entity.UserInfo;

import java.util.Map;

public interface UserInfoService {
    UserInfo getUserInfo(Integer uid);

    UserInfo updateUserInfo(updateUserInfoParams updateUserInfoParams);

    Map<String,long[]> getUserCategory(Integer uid);

}
