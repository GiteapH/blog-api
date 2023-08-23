package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.UserClockMapper;
import cn.springboot.blog.entity.UserClock;
import cn.springboot.blog.service.UserClockService;
import cn.springboot.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserClockSrviceImpl implements UserClockService {

    @Autowired
    UserClockMapper userClockMapper;


    @Override
    public UserClock updateEvent(UserClock userClock) {
        int effect = userClockMapper.updateByPrimaryKeySelective(userClock);
        if(effect==1){
            return userClock;
        }
        return null;
    }

    @Override
    public UserClock resetUserClock(UserClock userClock) {
        int effect = userClockMapper.insertSelective(userClock);
        if(effect==1){
            return userClock;
        }
        return null;
    }

    @Override
    public List<UserClock> getUserClocks(Integer uid, Date start, Date end) {
        List<UserClock> userClocks = null;
        try {
            userClocks = userClockMapper.selectAllUserClocks(start, end, uid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return  userClocks;
    }
}
