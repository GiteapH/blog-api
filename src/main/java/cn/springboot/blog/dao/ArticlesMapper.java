package cn.springboot.blog.dao;

import cn.springboot.blog.entity.Articles;
import java.util.*;

import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticlesMapper {
    int deleteByPrimaryKey(@Param("aid") Integer aid);

    int insert(Articles row);

    int insertSelective(Articles row);

    long getTotalArticles(Integer uid,String tag,String key);

    long getTotalCurDays(int type,String tag);

    List<Articles> getClasssys();

    List<UserAndArticle> getUser2Article(PageQueryUtil pageQueryUtil);

    List<Articles> getArticleByUid(PageQueryUtil pageQueryUtil);

    List<Articles> getArticleLike(PageQueryUtil pageQueryUtil);

    UserAndArticle selectByPrimaryKey(@Param("aid") Integer aid);

    Articles selectArticlesByPrimaryKey(@Param("aid") Integer aid);

    List<UserAndArticle> getUser2ArticleNearCurDay(PageQueryUtil pageQueryUtil);

    int updateByPrimaryKeySelective(Articles row);

    int updateByPrimaryKeyWithBLOBs(Articles row);

    int updateByPrimaryKey(Articles row);

    int updateIntParam(String oldParamName,String newParamName,Integer aid);

}