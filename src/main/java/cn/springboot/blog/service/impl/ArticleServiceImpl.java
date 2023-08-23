package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.ArticlesMapper;
import cn.springboot.blog.dao.DynamicMapper;
import cn.springboot.blog.entity.Articles;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.service.ArticleService;
import cn.springboot.blog.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    DynamicMapper dynamicMapper;
    @Override
    public long getArticleLen(Integer uid,String tag,String key){
        System.err.println(tag+" "+key);
        return articlesMapper.getTotalArticles(uid,tag,key);
    }

    @Override
    public long getCurDaysOOArticlesCount(Integer type,String tag) {
        return articlesMapper.getTotalCurDays(type,tag);
    }

    /**
     * @param aid
     * @return
     */
    @Override
    public Articles getArticleByKey(Integer aid) {
        return articlesMapper.selectArticlesByPrimaryKey(aid);
    }

    @Override
    public List<Articles> getArticleTags(){
        return articlesMapper.getClasssys();
    }

    public List<UserAndArticle> getUserAndArticle(PageQueryUtil pageQueryUtil) {
        return articlesMapper.getUser2Article(pageQueryUtil);
    }

    public UserAndArticle getArticle(int aid){
        return articlesMapper.selectByPrimaryKey(aid);
    }

    @Override
    public List<UserAndArticle> getAroundCurDayArticles(PageQueryUtil pageQueryUtil) {
        return articlesMapper.getUser2ArticleNearCurDay(pageQueryUtil);
    }

    @Override
    public int insertArticle(Articles articles) {
        int row = articlesMapper.insertSelective(articles);
        if(row!=0){
//            添加发布文章动态
            Dynamic dynamic = new Dynamic();
            dynamic.setDAid(articles.getAid());
            dynamic.setDContent("我发布了篇文章,快来看看吧");
            dynamic.setDDate(new Date());
            dynamic.setDType(2);
            dynamic.setDUid(articles.getUid());
            System.err.println("动态发布失败");
            return  dynamicMapper.insertSelective(dynamic);
        }
        return row;
    }

    @Override
    public int updateIntParams(String oldParamName, String newParamName, Integer aid) {
        return articlesMapper.updateIntParam(oldParamName,newParamName,aid);
    }

    @Override
    public int updateArticleParams(Articles articles) {
        return articlesMapper.updateByPrimaryKeySelective(articles);
    }

    @Override
    public List<Articles> getUserArticle(PageQueryUtil pageQueryUtil) {
        return  articlesMapper.getArticleByUid(pageQueryUtil);
    }

    @Override
    public int deleteArticle(Integer aid) {
        return articlesMapper.deleteByPrimaryKey(aid);
    }
}
