package cn.springboot.blog.service;

import cn.springboot.blog.entity.ConnectAndUser;
import cn.springboot.blog.entity.ConnectList;
import cn.springboot.blog.util.PageQueryUtil;
import java.util.*;
public interface ConnectListService {
    List<ConnectAndUser> getConnectList(PageQueryUtil pageQueryUtil);

    int updateConnectList(ConnectList connectList);

    int selectAllLenByPrincipal(Integer principal);

    int deleteByKey(Integer connectId);

    ConnectList insertConnectList(ConnectList connectList);

    Integer selectConnectIdByPrincipalAndSubordinate(Integer principal,Integer subordinate);
}
