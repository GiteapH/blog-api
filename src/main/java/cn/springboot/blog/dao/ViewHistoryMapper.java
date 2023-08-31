package cn.springboot.blog.dao;

import cn.springboot.blog.entity.ViewHistory;
import cn.springboot.blog.entity.ViewHistoryExample;
import java.util.List;

import cn.springboot.blog.entity.ViewHistoryWithArticle;
import org.apache.ibatis.annotations.Param;

public interface ViewHistoryMapper {
    long countByExample(ViewHistoryExample example);

    int deleteByExample(ViewHistoryExample example);

    int deleteByPrimaryKey(Integer hId);

    int insert(ViewHistory row);

    int insertSelective(ViewHistory row);

    List<ViewHistoryWithArticle> selectByExample(ViewHistoryExample example);

    ViewHistory selectByPrimaryKey(Integer htid,Integer huid);

    int updateByExampleSelective(@Param("row") ViewHistory row, @Param("example") ViewHistoryExample example);

    int updateByExample(@Param("row") ViewHistory row, @Param("example") ViewHistoryExample example);

    int updateByPrimaryKeySelective(ViewHistory row);

    int updateByPrimaryKey(ViewHistory row);
}