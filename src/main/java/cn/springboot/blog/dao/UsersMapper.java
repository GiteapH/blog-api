package cn.springboot.blog.dao;

import cn.springboot.blog.entity.UserInfoAndRegisterInfo;
import cn.springboot.blog.entity.Users;
import cn.springboot.blog.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface UsersMapper {
    int deleteByPrimaryKey(@Param("id") Long id, @Param("email") String email);

    int insert(Users row);

    int insertSelective(Users row);



    Users selectByPrimaryKey(@Param("id") Long id, @Param("email") String email);

    String selectFanGroups(Integer uid);

    int updateByPrimaryKeySelective(Users row);

    Users selectByLoginNameAndPasswd(String email,String password);

    Users selectByEmail(String email);

    int updateFanGroup(Integer uid,String newGroup);

    UserInfoAndRegisterInfo selectById(Long id);
    List<UserInfoAndRegisterInfo> findMallUserList(PageQueryUtil pageUtil);

    int getUserByKeyLen(PageQueryUtil pageUtil);
    List<UserInfoAndRegisterInfo> getUserListByKey(PageQueryUtil pageUtil);

    int getTotalMallUsers(PageQueryUtil pageUtil);

    int updateByPrimaryKeyWithBLOBs(Users row);

    int updateByPrimaryKey(Users row);
}