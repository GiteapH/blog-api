package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.GoodPointsMapper;
import cn.springboot.blog.entity.ArticlePointsCount;
import cn.springboot.blog.entity.GoodPoints;
import cn.springboot.blog.service.GoodPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodPointsServiceImpl implements GoodPointsService {
    @Autowired
    GoodPointsMapper goodPointsMapper;
    @Override
    public int delByKeys(Integer uid, Integer type, Integer id,Integer tableType) {
        return goodPointsMapper.deleteByGoodCid(uid,type,id,tableType);
    }


    @Override
    public int updateByKeys(GoodPoints goodPoints) {
        return goodPointsMapper.updateByPrimaryKeySelective(goodPoints);
    }

    /**
     * @param tableType
     * @param orderType
     * @return
     */
    @Override
    public Integer selectBestCid(Integer tableType,Integer orderType,Integer cTableId,Integer cType) {
       return goodPointsMapper.selectBest(tableType,orderType,cTableId,cType);
    }

    @Override
    public GoodPoints checkContain(Integer uid, Integer id,Integer tableType){
        return goodPointsMapper.selectByPrimaryKey(uid, id,tableType);
    }

    @Override
    public List<ArticlePointsCount> countType(Integer id,Integer tableType) {
        return goodPointsMapper.countByGoodId(id,tableType);
    }

    @Override
    public List<Integer> getTypeUids(Integer id, Integer type,Integer tableType) {
        return goodPointsMapper.getGoodUidListByType(type,id,tableType);
    }

    @Override
    public int onLikeActive(GoodPoints goodPoints) {
        return goodPointsMapper.insertSelective(goodPoints);
    }
}
