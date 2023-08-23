package cn.springboot.blog.service;

import cn.springboot.blog.entity.GoodCollections;
import cn.springboot.blog.entity.UserAndArticle;

import java.util.*;

public interface GoodCollectionsService {
    List<GoodCollections> getAllCollectByAid(Integer aid,Integer uid);

    List<UserAndArticle> getAllCollectByUid(Integer uid);

    int insertOne(GoodCollections goodCollections);

    int updateContain(GoodCollections goodCollections);

    int deleteContain(Integer collectId);

}
