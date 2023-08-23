package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.TopicMapper;
import cn.springboot.blog.entity.Topic;
import cn.springboot.blog.service.TopicService;
import cn.springboot.blog.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;
    /**
     * @param pageQueryUtil
     * @return
     */
    @Override
    public List<Topic> selectAll(PageQueryUtil pageQueryUtil) {
       return topicMapper.selectAll(pageQueryUtil);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Topic getTopicById(Integer id) {
       return topicMapper.selectByPrimaryKey(id);
    }
}
