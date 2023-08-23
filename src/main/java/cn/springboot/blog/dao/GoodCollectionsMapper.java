package cn.springboot.blog.dao;

import cn.springboot.blog.entity.GoodCollections;
import cn.springboot.blog.entity.UserAndArticle;

import java.util.*;
public interface GoodCollectionsMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(GoodCollections row);

    int insertSelective(GoodCollections row);

    GoodCollections selectByPrimaryKey(Integer collectId);

    List<GoodCollections> selectAllByGoodAid(Integer aid,Integer uid);

    List<UserAndArticle> selectAllCollectionsByGoodUid(Integer uid);

    int updateByPrimaryKeySelective(GoodCollections row);

    int updateByPrimaryKey(GoodCollections row);
}