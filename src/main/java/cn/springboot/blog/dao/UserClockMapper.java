package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserClock;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

public interface UserClockMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(UserClock row);

    int insertSelective(UserClock row);

    UserClock selectByPrimaryKey(Integer kid);

    List<UserClock> selectAllUserClocks(@DateTimeFormat(pattern = "yyyy-MM")Date start, @DateTimeFormat(pattern = "yyyy-MM")Date end, Integer uid);

    int updateByPrimaryKeySelective(UserClock row);

    int updateByPrimaryKey(UserClock row);
}