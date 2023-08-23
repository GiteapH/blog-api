package cn.springboot.blog.dao;
import cn.springboot.blog.entity.ArticlePointsCount;
import cn.springboot.blog.entity.GoodPoints;

import java.util.*;
public interface GoodPointsMapper {
    int deleteByPrimaryKey(Integer goodUid,Integer id,Integer tableType);

    int insert(GoodPoints row);

    Integer selectBest(Integer tableType,Integer orderType,Integer cTableId,Integer cType);

    int insertSelective(GoodPoints row);

    GoodPoints selectByPrimaryKey(Integer goodUid,Integer id,Integer tableType);

    int updateByPrimaryKeySelective(GoodPoints row);

    int updateByPrimaryKey(GoodPoints row);

    int deleteByGoodCid(Integer uid,Integer type, Integer id,Integer tableType);

    List<ArticlePointsCount> countByGoodId(Integer id,Integer tableType);

    List<Integer> getGoodUidListByType(Integer type,Integer id,Integer tableType);
}