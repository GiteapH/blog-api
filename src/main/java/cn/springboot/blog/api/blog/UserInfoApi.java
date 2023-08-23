package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.updateUserInfoParams;
import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.entity.UserInfo;
import cn.springboot.blog.entity.UserInfoAndRegisterInfo;
import cn.springboot.blog.service.TagCategoryService;
import cn.springboot.blog.service.UserInfoService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/v1")
@Api(value = "v1",tags = "用户数据信息接口文档")
public class UserInfoApi {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    TagCategoryService tagCategoryService;


    @GetMapping("info/userInfo")
    public Result userInfo(@RequestParam Integer uid){
        UserInfo userInfo = userInfoService.getUserInfo(uid);
        if(userInfo!=null){
            return ResultGenerator.genSuccessResult(userInfo);
        }
        return ResultGenerator.genFailResult("用户不存在");
    }

    @PutMapping("info/updateUserInfo")
    public Result updateUserInfo(@RequestBody updateUserInfoParams updateUserInfoParams){
        UserInfo userInfo = null;
        try {
            userInfo = userInfoService.updateUserInfo(updateUserInfoParams);
            if(userInfo!=null){
                return ResultGenerator.genSuccessResult(userInfo);
            }else{
                return ResultGenerator.genFailResult("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/info/getUserCategory")
    public Result getUserCategory(@RequestParam Integer uid){
        try{
            Set<Map.Entry<String, long[]>> userCategories = userInfoService.getUserCategory(uid).entrySet();
            Map<String,List<TagCategory>> result = new HashMap<>();
            for(Map.Entry<String,long[]> userCategory:userCategories){
                for(long id:userCategory.getValue()){
                    if(result.containsKey(userCategory.getKey())){
                        result.get(userCategory.getKey()).add(tagCategoryService.getTagCategoryByCategoryId(id));
                    }else {
                        List<TagCategory> tagCategoryList = new ArrayList<>();
                        tagCategoryList.add(tagCategoryService.getTagCategoryByCategoryId(id));
                        result.put(userCategory.getKey(),tagCategoryList);
                    }
                }
            }
            return ResultGenerator.genSuccessResult(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}
