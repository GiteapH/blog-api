package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.ConnectListMapper;
import cn.springboot.blog.entity.ConnectAndUser;
import cn.springboot.blog.entity.ConnectList;
import cn.springboot.blog.service.ConnectListService;
import cn.springboot.blog.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebEndpoint;
import java.util.List;

@Service
public class ConnectListServiceImpl implements ConnectListService {

    @Autowired
    ConnectListMapper connectListMapper;
    /**
     * @param pageQueryUtil
     * @return
     */
    @Override
    public List<ConnectAndUser> getConnectList(PageQueryUtil pageQueryUtil) {
        return connectListMapper.selectAllByPrincipalUid(pageQueryUtil);
    }



    /**
     * @param connectList
     * @return
     */
    @Override
    public int updateConnectList(ConnectList connectList) {
        return connectListMapper.updateByPrimaryKeySelective(connectList);
    }

    /**
     * @param principal
     * @return
     */
    @Override
    public int selectAllLenByPrincipal(Integer principal) {
       return connectListMapper.selectAllLenByPrincipalUid(principal);
    }

    /**
     * @param connectId
     * @return
     */
    @Override
    public int deleteByKey(Integer connectId) {
       return  connectListMapper.deleteByPrimaryKey(connectId);
    }

    /**
     * @param connectList
     * @return
     */
    @Override
    public ConnectList insertConnectList(ConnectList connectList) {
       int row =  connectListMapper.insertSelective(connectList);
       if(row>0){
           return connectList;
       }
       return null;
    }

    /**
     * @param principal
     * @param subordinate
     * @return
     */
    @Override
    public Integer selectConnectIdByPrincipalAndSubordinate(Integer principal, Integer subordinate) {
       return connectListMapper.selectConnectIdByPrincipalUidAndSubordinateUid(principal,subordinate);
    }
}
