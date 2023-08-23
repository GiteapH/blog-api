package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserCode;

public interface UserCodeMapper {
    int deleteByPrimaryKey(String email);

    int insert(UserCode row);

    int insertSelective(UserCode row);

    UserCode selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(UserCode row);

    int updateByPrimaryKey(UserCode row);
}