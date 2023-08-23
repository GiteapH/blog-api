package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.TagCategoryMapper;
import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.service.TagCategoryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagCategoryServiceImpl implements TagCategoryService {

    @Data
    public static class innerTagCategory{
        String categoryName;

        Long categoryId;
        List<innerTagCategory> sonCategories;

        public innerTagCategory(String categoryName,List<innerTagCategory> sonCategories,Long categoryId){
            this.categoryName = categoryName;
            this.sonCategories = sonCategories;
            this.categoryId = categoryId;
        }
    }
    @Autowired
    TagCategoryMapper tagCategoryMapper;

    @Override
    public List<TagCategory> getTagCategoryByLevel(Integer level) {
        return tagCategoryMapper.selectAllByCategoryByLevel(level);
    }

    @Override
    public List<TagCategory> getTagCategoryByParentId(Long pid) {
        return tagCategoryMapper.selectAllByCategoryByParentId(pid);
    }

    @Override
    public TagCategory getTagCategoryByCategoryId(Long id) {
        return tagCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void getSonCategories(Long id,List<innerTagCategory> innerTagCategory){
        List<TagCategory> tagCategoryById = getTagCategoryByParentId(id);
        if(tagCategoryById.size() == 0)return;
        for(TagCategory tagCategory:tagCategoryById){
            System.err.println(innerTagCategory);
            List<innerTagCategory> store = new ArrayList<>();
            innerTagCategory.add(new innerTagCategory(tagCategory.getCategoryName(),store,tagCategory.getCategoryId()));
            System.err.println("fatherIdName:"+innerTagCategory+" sons:"+tagCategory);
            getSonCategories(tagCategory.getCategoryId(), store);
        }
    }
}
