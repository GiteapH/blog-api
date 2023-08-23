package cn.springboot.blog.service;

import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.service.impl.TagCategoryServiceImpl;

import java.util.*;
public interface TagCategoryService {

    /**
    *@author 吕杨平
    *@Description 获取对应等级的标签
    *@Date 13:47 2023/2/8
    *@Param [level]
    *@Return java.util.List<cn.springboot.blog.entity.TagCategory>
    */
   List<TagCategory> getTagCategoryByLevel(Integer level);

    /**
     *@author 吕杨平
     *@Description 获取对应父分类id的标签
     *@Date 13:47 2023/2/8
     *@Param [level]
     *@Return java.util.List<cn.springboot.blog.entity.TagCategory>
     */
   List<TagCategory> getTagCategoryByParentId(Long pid);

   TagCategory getTagCategoryByCategoryId(Long id);

   void getSonCategories(Long id, List<TagCategoryServiceImpl.innerTagCategory> innerTagCategory);
}
