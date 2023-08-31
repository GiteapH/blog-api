package cn.springboot.blog.api.blog;

import cn.springboot.blog.config.liner.tagCategoryDict;
import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.service.TagCategoryService;
import cn.springboot.blog.service.impl.TagCategoryServiceImpl;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "v1", tags = "分类标签相关接口")
@RequestMapping("/api/v1")
public class TagCategoryApi {
    @Autowired
    TagCategoryService tagCategoryService;

    @GetMapping("/tag/categoriesById")
    public Result  categoriesById(@RequestParam Long gid){
        List<TagCategory> tagCategoryById = tagCategoryService.getTagCategoryByParentId(gid);
        return ResultGenerator.genSuccessResult(tagCategoryById);
    }


    @GetMapping("/tag/map")
    public Result  map(){
        return ResultGenerator.genSuccessResult(tagCategoryDict.tagCategoryMap);
    }
    @GetMapping("/tag/categoriesByLevel")
    public Result  categoriesByLevel(@RequestParam Integer level){
        List<TagCategory> tagCategoryByLevel = tagCategoryService.getTagCategoryByLevel(level);
        return ResultGenerator.genSuccessResult(tagCategoryByLevel);
    }
//    递归获取子类
    @GetMapping("/tag/categories")
    public Result  categoriesByLevel(){
        List<TagCategory> tagCategoryByLevel = tagCategoryService.getTagCategoryByLevel(1);
        List<TagCategoryServiceImpl.innerTagCategory> result = new ArrayList<>();
        for(TagCategory tagCategory:tagCategoryByLevel){
            List<TagCategoryServiceImpl.innerTagCategory> store = new ArrayList<>();
            TagCategoryServiceImpl.innerTagCategory innerTagCategory = new TagCategoryServiceImpl.innerTagCategory(tagCategory.getCategoryName(),store, tagCategory.getCategoryId());
            tagCategoryService.getSonCategories(tagCategory.getCategoryId(), store);
            result.add(innerTagCategory);
        }
        return ResultGenerator.genSuccessResult(result);
    }

}
