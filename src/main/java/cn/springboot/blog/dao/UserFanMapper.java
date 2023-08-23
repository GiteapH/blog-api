package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserAndFanned;
import cn.springboot.blog.entity.UserFan;
import cn.springboot.blog.util.PageQueryUtil;

import java.util.*;

public interface UserFanMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(UserFan row);

    int insertSelective(UserFan row);

    int lenUserFans(Integer loginUid,Integer type);

    int lenUserFanList(Integer loginUid);

    UserFan selectByPrimaryKey(Integer fid);

//    关注
    List<UserAndFanned> selectUserFans(PageQueryUtil pageQueryUtil);

//    粉丝
    List<UserAndFanned> selectUserFansList(PageQueryUtil pageQueryUtil);
    Integer selectUserFanEachOther(Integer loginUid,Integer upUid,Integer type);

    UserFan selectByFTouidAndFUid(Integer upUid,Integer loginUid);

    int updateByPrimaryKeySelective(UserFan row);

    int updateByPrimaryKey(UserFan row);
}