package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserModules;

public interface UserModulesMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserModules row);

    int insertSelective(UserModules row);

    UserModules selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserModules row);

    int updateByPrimaryKey(UserModules row);
}