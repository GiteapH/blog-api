package cn.springboot.blog.service;

import cn.springboot.blog.entity.UserClock;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface UserClockService {
    UserClock updateEvent(UserClock userClock);


    UserClock resetUserClock(UserClock userClock);

    List<UserClock> getUserClocks(Integer uid, Date start, Date end);
}
