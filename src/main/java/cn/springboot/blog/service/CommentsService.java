package cn.springboot.blog.service;

import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;

import java.util.*;

public interface CommentsService {
    List<CommentAndUser> getComments(Integer aid,Integer cType,Integer orderColumn);
    int insertComments(Comments comments,Boolean need);

    CommentAndUser getCommentByKey(Integer cid);

    List<CommentAndUser> getDetailComments( Integer aid, Integer cid,Integer cType);
}
