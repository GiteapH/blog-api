package cn.springboot.blog.service;


import cn.springboot.blog.entity.ArticlePointsCount;
import cn.springboot.blog.entity.GoodPoints;
import  java.util.*;

public interface GoodPointsService {
    int delByKeys(Integer uid,Integer type, Integer id,Integer tableType);
    int updateByKeys(GoodPoints goodPoints);

    /**
     *@author 吕杨平
     *@Description 点赞数(1,0,动态id,2  /  2,5,文章id,1) 转发数(2,6,动态id,2)
     *@Date 12:20 2023/3/13
     *@Param [tableType, orderType, cTableId, cType]
     *@Return java.lang.Integer
     */
    Integer selectBestCid(Integer tableType,Integer oderType,Integer cTableId,Integer cType);

//    点赞插入
    int onLikeActive(GoodPoints goodPoints);

    GoodPoints checkContain(Integer uid,Integer id,Integer tableType);

    List<ArticlePointsCount> countType(Integer id,Integer tableType);

    List<Integer> getTypeUids(Integer id,Integer type,Integer tableType);
}
