package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.DynamicMapper;
import cn.springboot.blog.entity.*;
import cn.springboot.blog.service.ArticleService;
import cn.springboot.blog.service.CommentsService;
import cn.springboot.blog.service.DynamicService;
import cn.springboot.blog.service.GoodPointsService;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicServiceImpl implements DynamicService{
    @Autowired
    DynamicMapper dynamicMapper;

    @Autowired
    CommentsService commentsService;

    @Autowired
    TopicServiceImpl topicService;

    @Autowired
    ArticleService articleService;

    @Autowired
    GoodPointsService goodPointsService;
    /**
     * @param pageQueryUtil
     * @return 列表信息
     */
    @Override
    public List<Map<String, Object>> getDynamicInfo(PageQueryUtil pageQueryUtil) {
        List<Map<String, Object>> res = new ArrayList<>();
        CommentAndUser comment;
        Articles article;
        List<DynamicAndUser> dynamicAndUsers = dynamicMapper.selectAllByDUid(pageQueryUtil);
        try{
            for(DynamicAndUser dynamicAndUser:dynamicAndUsers){
                Map<String,Object> map = new LinkedHashMap<>();
//            动态类型与关联id
                Integer type = dynamicAndUser.getDType(),
                        id = dynamicAndUser.getDAid();
//            评论动态
                if(type==1){
                    comment = commentsService.getCommentByKey(id);
                    CommentAndUser comments = commentsService.getCommentByKey(id);
                    Map<String,Object> commentInfo = new HashMap<>();
                    commentInfo.put("comment",comment);
                    commentInfo.put("replayComment",comments);
                    map.put("commentInfo",commentInfo);
                }
                else if(type==2){
                    article =  articleService.getArticleByKey(id);
                    Integer cid = goodPointsService.selectBestCid(1, 0, id, 1);
                    System.err.println(cid);
                    comment = commentsService.getCommentByKey(cid);
                    System.err.println(comment);
                    Map<String,Object> articleInfo = new HashMap<>();
                    articleInfo.put("article",article);
                    articleInfo.put("bestComment",comment);
                    map.put("articleInfo",articleInfo);
                }

//             判断用户是否点赞
                List<Integer> typeUids = goodPointsService.getTypeUids(dynamicAndUser.getDid(), 5, 2);
                if(dynamicAndUser.getTopicId()!=null){
                    map.put("topicInfo",topicService.getTopicById(dynamicAndUser.getTopicId()));
                }
                map.put("DynamicInfo",dynamicAndUser);
                map.put("uidSet",typeUids);
                res.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return res;
    }

    /**
     * @param dynamic
     * @return
     */
    @Override
    public int insertDynamic(Dynamic dynamic) {
        System.err.println((dynamic));
        return dynamicMapper.insertSelective(dynamic);
    }

    /**
     * @param dynamic
     * @return
     */
    @Override
    public int updateParams(Dynamic dynamic) {
       return dynamicMapper.updateByPrimaryKeySelective(dynamic);
    }
}
