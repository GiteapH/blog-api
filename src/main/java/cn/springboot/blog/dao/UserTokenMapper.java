package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserToken;

public interface UserTokenMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserToken row);

    int insertSelective(UserToken row);

    UserToken selectByPrimaryKey(Long userId);

    UserToken selectByToken(String token);

    int updateByPrimaryKeySelective(UserToken row);

    int updateByPrimaryKey(UserToken row);
}