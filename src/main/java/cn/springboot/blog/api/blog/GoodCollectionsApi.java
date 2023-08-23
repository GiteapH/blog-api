package cn.springboot.blog.api.blog;


import cn.springboot.blog.api.blog.param.GoodCollectionParam;
import cn.springboot.blog.entity.GoodCollections;
import cn.springboot.blog.entity.UserAndArticle;
import cn.springboot.blog.service.ArticleService;
import cn.springboot.blog.service.GoodCollectionsService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "v1", tags = "收藏接口")
@RequestMapping("/api/v1")
public class GoodCollectionsApi {
    
    @Autowired
    GoodCollectionsService goodCollectionsService;
    @Autowired
    ArticleService articleService;

    
    @GetMapping("/goodCollection/getAllByAid")
    Result getAllByAid(@RequestParam(required = false) Integer aid){
        List<GoodCollections> allCollectByAid;
        try {
            allCollectByAid = goodCollectionsService.getAllCollectByAid(aid,null);
        }catch (Exception e){
           return  ResultGenerator.genErrorResult(500,e.getMessage());
        }
        return ResultGenerator.genSuccessResult(allCollectByAid);
    }

    @GetMapping("/goodCollection/getAllByUid")
    Result getAllByUid(@RequestParam(required = false) Integer uid){
        List<UserAndArticle> allCollectByUid;
        try {
            allCollectByUid = goodCollectionsService.getAllCollectByUid(uid);
        }catch (Exception e){
            e.printStackTrace();
            return  ResultGenerator.genErrorResult(500,e.getMessage());
        }
        return ResultGenerator.genSuccessResult(allCollectByUid);
    }



    @PutMapping("/goodCollection/onAddCollection")
    Result onAddCollection(@RequestBody GoodCollectionParam goodCollectionParam){
        GoodCollections goodCollections = new GoodCollections();
        Integer uid = goodCollectionParam.getUid(),aid = goodCollectionParam.getAid();
        goodCollections.setGoodUid(uid);
        goodCollections.setGoodAid(aid);
        goodCollections.setTime(new Date());
        List<GoodCollections> selectCollect;

        try {
            selectCollect = goodCollectionsService.getAllCollectByAid(aid, uid);
        }
        catch (Exception e){
            return ResultGenerator.genErrorResult(500, e.getMessage());
        }

        if(selectCollect.size()==0){
            int rows = goodCollectionsService.insertOne(goodCollections);
            int intParams = articleService.updateIntParams(null,"collected",goodCollectionParam.getAid());
            if(rows!=0){
                Map<String,String> map = new HashMap<>();
                map.put("effectRows",String.valueOf(rows));
                map.put("action","添加收藏");
                return  ResultGenerator.genSuccessResult(map);
            }else{
                if(intParams==0)return ResultGenerator.genFailResult("关联表更新失败");
                return ResultGenerator.genFailResult("收藏失败");
            }
        }else {
            GoodCollections containColl = selectCollect.get(0);
            int rows = goodCollectionsService.deleteContain(containColl.getCollectId());
            int intParams = articleService.updateIntParams("collected",null,goodCollectionParam.getAid());
            if(rows!=0){
                Map<String,String> map = new HashMap<>();
                map.put("effectRows",String.valueOf(rows));
                map.put("action","取消收藏");
                return  ResultGenerator.genSuccessResult(map);
            }else{
                if(intParams==0)return ResultGenerator.genFailResult("关联表更新失败");
                return ResultGenerator.genFailResult("取消收藏失败");
            }
        }
    }
}
