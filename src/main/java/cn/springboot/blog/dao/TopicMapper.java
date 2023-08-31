package cn.springboot.blog.dao;

import cn.springboot.blog.entity.Topic;
import cn.springboot.blog.util.PageQueryUtil;
import java.util.*;


public interface TopicMapper {
    int deleteByPrimaryKey(Integer tid);
    List<Topic> selectAll(PageQueryUtil pageQueryUtil);

    Integer selectOneByTTopic(String topic);

    int insert(Topic row);

    int insertSelective(Topic row);

    Topic selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Topic row);

    int updateByPrimaryKey(Topic row);
}