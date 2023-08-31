package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.ViewHistoryMapper;
import cn.springboot.blog.entity.ViewHistory;
import cn.springboot.blog.entity.ViewHistoryExample;
import cn.springboot.blog.entity.ViewHistoryWithArticle;
import cn.springboot.blog.service.ViewHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/8/27 10:27
 */
@Service
public class ViewHistoryServiceImpl implements ViewHistoryService {
    @Autowired
    ViewHistoryMapper viewHistoryMapper;
    /**
     * @param viewHistory
     * @return
     */
    @Override
    public int updateViewHistroy(ViewHistory viewHistory) {
        return viewHistoryMapper.updateByPrimaryKeySelective(viewHistory);
    }

    /**
     * @param viewHistory
     * @return
     */
    @Override
    public int insertViewHistroy(ViewHistory viewHistory) {
        return viewHistoryMapper.insertSelective(viewHistory);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public int deleteByKey(Integer key) {
        return viewHistoryMapper.deleteByPrimaryKey(key);
    }

    /**
     * @param uid
     * @return
     */
    @Override
    public int deleteAll(Integer uid) {
        ViewHistoryExample viewHistoryExample = new ViewHistoryExample();
        viewHistoryExample.createCriteria().andHUidEqualTo(uid);
        return viewHistoryMapper.deleteByExample(viewHistoryExample);
    }

    /**
     * @param htid
     * @param huid
     * @return
     */
    @Override
    public ViewHistory selectByExample(Integer htid, Integer huid) {
        return  viewHistoryMapper.selectByPrimaryKey(htid,huid);
    }

    /**
     * @param uid
     * @return
     */
    @Override
    public List<ViewHistoryWithArticle> selectAllUid(Integer uid) {
        ViewHistoryExample viewHistoryExample = new ViewHistoryExample();
        viewHistoryExample.setOrderByClause("h_date");
        ViewHistoryExample.Criteria criteria = viewHistoryExample.createCriteria();
        criteria.andHUidEqualTo(uid);

        List<ViewHistoryWithArticle> viewHistories;
        try{
            viewHistories = viewHistoryMapper.selectByExample(viewHistoryExample);
        }catch (Exception e) {
            return null;
        }
        return viewHistories;
    }

    /**
     * @param search
     * @param uid
     * @return
     */
    @Override
    public List<ViewHistoryWithArticle> selectAllByTitle(String search, Integer uid) {
        ViewHistoryExample viewHistoryExample = new ViewHistoryExample();
        viewHistoryExample.setOrderByClause("h_date");
        viewHistoryExample.setSearch(search);
        ViewHistoryExample.Criteria criteria = viewHistoryExample.createCriteria();
        criteria.andHUidEqualTo(uid);
        List<ViewHistoryWithArticle> viewHistories;
        try{
            viewHistories = viewHistoryMapper.selectByExample(viewHistoryExample);
        }catch (Exception e) {
            return null;
        }
        return viewHistories;
    }
}
