package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.CommentsMapper;
import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.service.CommentsService;
import cn.springboot.blog.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    DynamicService dynamicService;

    @Override
    public List<CommentAndUser> getComments(Integer aid,Integer cType,Integer orderColumn) {
        List<CommentAndUser> commentAndUsers;
        try{
            commentAndUsers = commentsMapper.selectAllByAidAndUid(aid,cType,orderColumn);
        }catch (Exception e){
            e.printStackTrace();
           return null;
        }
        return commentAndUsers;
    }

    @Override
    public int insertComments(Comments comments,Boolean need) {
        System.out.println(need);
//        回复评论动态插入
        if(comments.getReplayCid()!=null&&need){
            Dynamic dynamic = new Dynamic();
            dynamic.setDAid(comments.getReplayCid());
            dynamic.setDContent(comments.getContent());
            dynamic.setDDate(new Date());
            dynamic.setDType(1);
            dynamic.setDUid(comments.getFromUid());
            int row = dynamicService.insertDynamic(dynamic);
            if(row!=0)
                return commentsMapper.insertSelective(comments);
            return 0;
        }
        return commentsMapper.insertSelective(comments);
    }

    /**
     * @param cid
     * @return
     */
    @Override
    public CommentAndUser getCommentByKey(Integer cid) {
      return  commentsMapper.selectByPrimaryKey(cid);
    }

    @Override
    public List<CommentAndUser> getDetailComments(@RequestParam Integer aid,@RequestParam Integer cid,@RequestParam(defaultValue = "0")Integer cType) {
        return commentsMapper.selectAllByPrimaryKeyAnd(aid, cid,cType);
    }
}
