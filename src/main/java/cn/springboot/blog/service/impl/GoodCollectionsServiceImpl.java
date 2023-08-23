package cn.springboot.blog.service.impl;

import cn.springboot.blog.entity.GoodCollections;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.service.GoodCollectionsService;
import cn.springboot.blog.dao.GoodCollectionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodCollectionsServiceImpl implements GoodCollectionsService {

    @Autowired
    GoodCollectionsMapper goodCollectionsMapper;

    @Override
    public List<GoodCollections> getAllCollectByAid(Integer aid,Integer uid) {
        return goodCollectionsMapper.selectAllByGoodAid(aid,uid);
    }

    @Override
    public List<UserAndArticle> getAllCollectByUid(Integer uid) {
        return goodCollectionsMapper.selectAllCollectionsByGoodUid(uid);
    }

    @Override
    public int insertOne(GoodCollections goodCollections) {
        return goodCollectionsMapper.insertSelective(goodCollections);
    }

    @Override
    public int updateContain(GoodCollections goodCollections) {
        return goodCollectionsMapper.updateByPrimaryKeySelective(goodCollections);
    }

    @Override
    public int deleteContain(Integer collectId) {
        return goodCollectionsMapper.deleteByPrimaryKey(collectId);
    }


}
