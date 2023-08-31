package cn.springboot.blog.api.blog;

import cn.springboot.blog.config.liner.tagCategoryDict;
import cn.springboot.blog.entity.UserModules;
import cn.springboot.blog.entity.ViewHistory;
import cn.springboot.blog.entity.ViewHistoryWithArticle;
import cn.springboot.blog.service.UserModuleService;
import cn.springboot.blog.service.ViewHistoryService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import cn.springboot.blog.util.SystemUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(value = "v1", tags = "用户历史记录操作接口")
@RequestMapping("/api/v1")
public class ViewHistoryApi {

    @Autowired
    ViewHistoryService viewHistoryService;

    @PutMapping("/view-history/addHistory")
    Result addHistory(@RequestBody ViewHistory viewHistory){
        ViewHistory contain = viewHistoryService.selectByExample(viewHistory.getHTId(), viewHistory.getHUid());
        //        已存在
        if(contain!=null){
            contain.setHDate(new Date());
            int row = viewHistoryService.updateViewHistroy(contain);
            if (row > 0) {
                return ResultGenerator.genSuccessResult("操作成功");
            } else {
                return ResultGenerator.genFailResult("操作失败");
            }
        }else {
            int row = viewHistoryService.insertViewHistroy(viewHistory);
            if (row > 0) {
                return ResultGenerator.genSuccessResult("操作成功");
            } else {
                return ResultGenerator.genFailResult("操作失败");
            }
        }
    }

    @PostMapping("/view-history/updateHistory")
    Result updateHistory(@RequestBody ViewHistory viewHistory){
        int row = viewHistoryService.updateViewHistroy(viewHistory);
        if(row > 0){
            return ResultGenerator.genSuccessResult("操作成功");
        }else{
            return ResultGenerator.genFailResult("操作失败");
        }
    }

    @DeleteMapping("/view-history/deleteHistory")
    Result deleteHistory(@RequestBody ViewHistory viewHistory){
        int row = viewHistoryService.deleteByKey(viewHistory.getHId());
        if(row > 0){
            return ResultGenerator.genSuccessResult("操作成功");
        }else{
            return ResultGenerator.genFailResult("操作失败");
        }
    }

    @DeleteMapping("/view-history/deleteAll")
    Result deleteAll(@RequestBody ViewHistory viewHistory){
        int row = viewHistoryService.deleteAll(viewHistory.getHUid());
        if(row > 0){
            return ResultGenerator.genSuccessResult("操作成功");
        }else{
            return ResultGenerator.genFailResult("操作失败");
        }
    }

    @GetMapping("/view-history/selectHistory")
    Result selectHistory(@RequestParam Integer huid){
        List<ViewHistoryWithArticle> viewHistories = viewHistoryService.selectAllUid(huid);
        viewHistories.forEach((viewHistory)->{
            String classify = viewHistory.getClasssys();
            String[] s = "".equals(classify)?new String[]{}:classify.split(" ");
            for(int i=0;i<s.length;i++){
                s[i] = tagCategoryDict.tagCategoryMap.getOrDefault(Long.valueOf(s[i]),"不存在");
            }
            viewHistory.setClasssys(String.join(" ",s));
        });
        if(viewHistories != null){
            return ResultGenerator.genSuccessResult(viewHistories);
        }else{
            return ResultGenerator.genFailResult("操作失败");
        }
    }

    @GetMapping("/view-history/search")
    Result search(@RequestParam Integer huid,@RequestParam String search){
        List<ViewHistoryWithArticle> viewHistories = viewHistoryService.selectAllByTitle(search,huid);
        viewHistories.forEach((viewHistory)->{
            String classify = viewHistory.getClasssys();
            String[] s = "".equals(classify)?new String[]{}:classify.split(" ");
            for(int i=0;i<s.length;i++){
                s[i] = tagCategoryDict.tagCategoryMap.getOrDefault(Long.valueOf(s[i]),"不存在");
            }
            viewHistory.setClasssys(String.join(" ",s));
        });
        if(viewHistories != null){
            return ResultGenerator.genSuccessResult(viewHistories);
        }else{
            return ResultGenerator.genFailResult("操作失败");
        }
    }
}
