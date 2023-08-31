package cn.springboot.blog.api.blog;


import cn.springboot.blog.entity.Topic;
import cn.springboot.blog.service.TopicService;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "v1", tags = "主题相关接口")
@RequestMapping("/api/v1")
public class TopicApi {
    @Autowired
    TopicService topicService;


    @GetMapping("/topic/getAllTopic")
    public Result getAllTopic(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "15") Integer limit,@RequestParam String key){
        Map<String, Object> store = new HashMap<>();
        store.put("page",page);
        store.put("limit",limit);
        store.put("key",key);
        List<Topic> topics;
        try {
            topics = topicService.selectAll(new PageQueryUtil(store));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult(topics);
    }

    @PostMapping("/topic/createTopic")
    public Result createTopic(@RequestBody Topic topic){
        Integer tid = topicService.getIdByTopic(topic.getTTopic());
        System.err.println(tid);
//        不存在创建
        if(tid==null){
           try {
               Topic topicCreate = topicService.insertTopic(topic);
               return ResultGenerator.genSuccessResult(topicCreate);
           }catch (Exception e){
               return ResultGenerator.genFailResult(e.getMessage());
           }
        }
        return ResultGenerator.genFailResult("话题已存在");
    }
}
