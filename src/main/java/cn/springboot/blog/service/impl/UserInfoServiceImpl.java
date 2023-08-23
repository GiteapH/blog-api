package cn.springboot.blog.service.impl;

import cn.springboot.blog.api.blog.param.updateUserInfoParams;
import cn.springboot.blog.dao.UserInfoMapper;
import cn.springboot.blog.entity.UserInfo;
import cn.springboot.blog.service.UserClockService;
import cn.springboot.blog.service.UserInfoService;
import cn.springboot.blog.util.BeanUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo getUserInfo(Integer uid) {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    @Override
    public UserInfo updateUserInfo(updateUserInfoParams updateUserInfoParams) {
        UserInfo userInfo = new UserInfo();
        UserInfo o = (UserInfo) BeanUtil.copyProperties(updateUserInfoParams, userInfo);
        int effect = userInfoMapper.updateByPrimaryKeySelective(o);
        if(effect!=0){
            return o;
        }else{
            return null;
        }
    }

    @Override
    public Map<String,long[]> getUserCategory(Integer uid) {
        Map<String,long[]> res = new HashMap<>();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
        if(userInfo==null)return null;
        String[] dislikeCategory = userInfo.getDislikeCategory().equals("")?null: userInfo.getDislikeCategory().split(",");
        String[] likeCategory = userInfo.getLikeCategory().equals("")?null: userInfo.getLikeCategory().split(",");
        res.put("dislikeCategory",dislikeCategory==null?new long[0]:Arrays.stream(dislikeCategory).mapToLong(Long::parseLong).toArray());
        res.put("likeCategory",likeCategory==null?new long[0]:Arrays.stream(likeCategory).mapToLong(Long::parseLong).toArray());
        return res;
    }
}
