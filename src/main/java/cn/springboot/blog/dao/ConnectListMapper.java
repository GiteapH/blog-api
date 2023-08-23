package cn.springboot.blog.dao;

import cn.springboot.blog.entity.ConnectAndUser;
import cn.springboot.blog.entity.ConnectList;
import cn.springboot.blog.util.PageQueryUtil;

import java.util.*;

public interface ConnectListMapper {
    int deleteByPrimaryKey(Integer connectId);

    int insert(ConnectList row);

    int insertSelective(ConnectList row);

    int selectAllLenByPrincipalUid(Integer principal);

    ConnectList selectByPrimaryKey(Integer connectId);

    List<ConnectAndUser> selectAllByPrincipalUid(PageQueryUtil pageQueryUtil);

    int updateByPrimaryKeySelective(ConnectList row);

    Integer selectConnectIdByPrincipalUidAndSubordinateUid(Integer principalUid,Integer subordinateUid);

    int updateByPrimaryKey(ConnectList row);
}