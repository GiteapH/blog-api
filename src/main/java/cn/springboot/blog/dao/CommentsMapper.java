package cn.springboot.blog.dao;

import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Comments row);

    int insertSelective(Comments row);

    CommentAndUser selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Comments row);

    int updateByPrimaryKeyWithBLOBs(Comments row);

    int updateByPrimaryKey(Comments row);

    List<CommentAndUser> selectAllByAidAndUid( @Param("aid") Integer aid,@Param("cType") Integer cType,Integer orderColumn);

    List<CommentAndUser> selectAllByPrimaryKeyAnd(@Param("aid") Integer aid, @Param("cid") Integer cid,@Param("cType") Integer cType);
}