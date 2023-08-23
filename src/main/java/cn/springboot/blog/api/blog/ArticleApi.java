package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.ArticleParams;
import cn.springboot.blog.api.blog.param.ArticleUpdateParams;
import cn.springboot.blog.api.blog.vo.LenV0;
import cn.springboot.blog.entity.ArticlePointsCount;
import cn.springboot.blog.entity.Articles;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.service.ArticleService;
import java.util.*;

import cn.springboot.blog.service.GoodPointsService;
import cn.springboot.blog.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "v1", tags = "文章操作相关接口")
@RequestMapping("/api/v1")
public class ArticleApi {
    @Resource
    ArticleService articleService;

    @Resource
    GoodPointsService goodPointsService;

    @GetMapping("/article/getAllActLen")
    public Result getLen(@RequestParam(required = false) Integer uid,
                         @RequestParam(required = false) String tag,
                         @RequestParam(required = false) String key){
        LenV0 lenV0 = new LenV0();
        try{
            lenV0.setLen(articleService.getArticleLen(uid,tag,key));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500, e.getMessage());
        }
        return ResultGenerator.genSuccessResult(lenV0);
    }

    @GetMapping("/article/getUserArticle")
    public Result getUserArticle(@RequestParam Integer uid,@RequestParam(defaultValue = "1") Integer start){
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("page",start);
            map.put("limit",1);
            map.put("uid",uid);
            PageQueryUtil pageQueryUtil = new PageQueryUtil(map);
            List<Articles> userArticle = articleService.getUserArticle(pageQueryUtil);
            return ResultGenerator.genSuccessResult(userArticle);
        }catch (Exception e){
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/article/getTags")
    public Result<String> getTags(){
        List<Articles> articleTags;

        try {
            articleTags = articleService.getArticleTags();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500, e.getMessage());
        }
        Map<String,Integer> map = new HashMap<>();
        for(Articles articles:articleTags){
            if(articles.getClasssys()!=null) {
                for(String s:articles.getClasssys().split(" ")){
                    if(!s.equals(""))
                        map.merge(s,1, Integer::sum);
                }
            }
        }
        return ResultGenerator.genSuccessResult(map);

    }

    @GetMapping("/article/getUsers2Article")
    public Result getUsers2Article(@RequestParam(required = false,defaultValue = "0") @ApiParam(value = "排序依据") Integer orderPath,
                                           @RequestParam(required = false,defaultValue = "1") @ApiParam(value = "页码") Integer pageNumber,
                                           @RequestParam(required = false) @ApiParam(value = "标签名") String tag,
                                            @RequestParam(required = false) @ApiParam(value = "关键字") String key){
        Map<String, Object> store = new HashMap<>();
        store.put("page",pageNumber);
        store.put("tag",tag);
        store.put("limit",15);
        store.put("orderName", SystemUtil.getOrderName(orderPath));
        store.put("key", key);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(store);
        List<UserAndArticle> userAndArticle;
        try{
            userAndArticle = articleService.getUserAndArticle(pageQueryUtil);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500,e.getLocalizedMessage());
        }
        System.out.println(pageQueryUtil);
        return ResultGenerator.genSuccessResult(userAndArticle);

    }

    @GetMapping("/article/getArticleById")
    public Result getArticleById(@RequestParam Integer aid){
        UserAndArticle article = articleService.getArticle(aid);
        List<ArticlePointsCount> articlePointsCounts = goodPointsService.countType(aid,0);
        Map<Integer,List<Integer>> typeUids = new HashMap<>();
        for(int i=2;i<4;i++){
            List<Integer> typeUidsList = goodPointsService.getTypeUids(aid, i,0);
            typeUids.put(i, typeUidsList);
        }
        if(article!=null){
            article.setTypeUidsMap(typeUids);
            article.setCountType(articlePointsCounts);
            return ResultGenerator.genSuccessResult(article);
        }else{
           return ResultGenerator.genFailResult("获取文章错误");
        }
    }

    @GetMapping("/article/getAroundCurDay")
    public Result getAroundCurDay(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "15") Integer limit,
                                  @RequestParam(required = false,defaultValue = "0") @ApiParam(value = "排序依据") Integer orderPath,
                                  @RequestParam(defaultValue = "") @ApiParam(value = "标签名") String tag){
        Map<String, Object> store = new HashMap<>();
        store.put("page",page);
        store.put("tag",tag);
        store.put("limit",limit);
        store.put("orderName", SystemUtil.getOrderName(orderPath));
        PageQueryUtil pageQueryUtil = new PageQueryUtil(store);
        try {
            long curDaysOOArticlesCount = articleService.getCurDaysOOArticlesCount(1,tag);
            System.err.println(curDaysOOArticlesCount);
            Map<String,Object> ret = new HashMap();
            ret.put("count",curDaysOOArticlesCount);
            List<UserAndArticle> aroundCurDayArticles = articleService.getAroundCurDayArticles(pageQueryUtil);
            ret.put("list",aroundCurDayArticles);
            return ResultGenerator.genSuccessResult(ret);
        } catch (Exception e) {
            return ResultGenerator.genErrorResult(500,e.getMessage());
        }

    }

    @PostMapping("/article/uploadArticle")
    public Result uploadArticle(@RequestBody ArticleParams articleParams){
        if(articleParams.getAid()!=null){
            return ResultGenerator.genErrorResult(500,"文章已存在,请点击保存");
        }

        Articles articles = new Articles();
        articles.setArticles(articleParams.getArticles());
        articles.setUid(articleParams.getUid());
        articles.setDate(new Date());
        articles.setTinymes(articleParams.getTinyMes());
        articles.setClassper(articleParams.getTagsPer());
        articles.setClasssys(articleParams.getTagsSys());
        articles.setTitle(articleParams.getTitle());
        int effectRows;
       try{
           effectRows =  articleService.insertArticle(articles);
       }catch (Exception e){
           e.printStackTrace();
           return ResultGenerator.genFailResult("上传失败");
       }
       if(effectRows==0){
           return ResultGenerator.genFailResult("上传文章发生未知错误");
       }
       return ResultGenerator.genSuccessResult(effectRows);
    }


    @DeleteMapping("/article/deleteAct")
    public Result deleteAct(@RequestParam Integer aid){
        try {
            int effectRows = articleService.deleteArticle(aid);
            if(effectRows==0){
                return ResultGenerator.genErrorResult(500,"不存在");
            }
            return ResultGenerator.genSuccessResult(effectRows);
        }catch (Exception e){
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/article/saveArt")
    public Result saveArt(@RequestBody ArticleParams articleParams){
        Articles articles = new Articles();
        articles.setTitle(articleParams.getTitle());
        articles.setClasssys(articleParams.getTagsSys());
        articles.setUid(articleParams.getUid());
        articles.setAid(articleParams.getAid());
        articles.setArticles(articleParams.getArticles());
        articles.setClassper(articleParams.getTagsPer());
        articles.setTinymes(articleParams.getTinyMes());

        try {
            int rows = articleService.updateArticleParams(articles);
            if(rows==0){
                return ResultGenerator.genFailResult("保存失败");
            }
            return ResultGenerator.genSuccessResult(rows);
        }catch (Exception e){
            return ResultGenerator.genErrorResult(500,e.getMessage());
        }
    }

    @PutMapping("/article/updateIntInfo")
    public Result saveArt(@RequestBody ArticleUpdateParams articleUpdateParams){
        System.out.println("articleUpdateParams = " + articleUpdateParams);
        try {
            int rows = articleService.updateIntParams(
                    articleUpdateParams.getOldParamName()!=null?SystemUtil.getParamName(articleUpdateParams.getOldParamName()):null,
                    articleUpdateParams.getNewParamName()!=null?SystemUtil.getParamName(articleUpdateParams.getNewParamName()):null,
                    articleUpdateParams.getAid()
            );
            if(rows==0){
                return ResultGenerator.genFailResult("更新失败");
            }
            return ResultGenerator.genSuccessResult(rows);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500,e.getMessage());
        }
    }
}
