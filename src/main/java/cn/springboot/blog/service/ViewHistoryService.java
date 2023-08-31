package cn.springboot.blog.service;

import cn.springboot.blog.entity.ViewHistory;
import cn.springboot.blog.entity.ViewHistoryWithArticle;

import javax.swing.text.View;
import java.util.*;

public interface ViewHistoryService {
    int updateViewHistroy(ViewHistory viewHistory);

    int insertViewHistroy(ViewHistory viewHistory);

    int deleteByKey(Integer key);

    int deleteAll(Integer uid);

    ViewHistory selectByExample(Integer htid, Integer huid);

    List<ViewHistoryWithArticle> selectAllUid(Integer uid);

    List<ViewHistoryWithArticle> selectAllByTitle(String search,Integer uid);
}
