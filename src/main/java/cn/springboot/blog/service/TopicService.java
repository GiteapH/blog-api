package cn.springboot.blog.service;

import cn.springboot.blog.entity.Topic;
import cn.springboot.blog.util.PageQueryUtil;

import java.util.*;
public interface TopicService {

    List<Topic> selectAll(PageQueryUtil pageQueryUtil);

    Topic getTopicById(Integer id);

    Topic insertTopic(Topic topic);

    Integer getIdByTopic(String topic);
}
