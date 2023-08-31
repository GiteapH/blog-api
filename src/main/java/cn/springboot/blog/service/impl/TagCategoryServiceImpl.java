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

    /**
     * @param tagName
     * @return
     */
    @Override
    public Integer getIDByName(String tagName) {

        return tagCategoryMapper.selectByCategoryName(tagName);
    }

    @Override
    public TagCategory getTagCategoryByCategoryId(Long id) {
        return tagCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * @return
     */
    @Override
    public List<TagCategory> getAll() {
       return tagCategoryMapper.selectALL();
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<TagCategory> getTagCategoriesByIds(List<String> ids) {
       return tagCategoryMapper.getTagCategoriesByIds(ids);
    }

    @Override
    public void getSonCategories(Long id,List<innerTagCategory> innerTagCategory){

//        保证标签间的链式、所以不需要剪枝

//        根据父id获取他的子标签
        List<TagCategory> tagCategoryById = getTagCategoryByParentId(id);
//        不存在子标签
        if(tagCategoryById.size() == 0)return;
        for(TagCategory tagCategory:tagCategoryById){
            List<innerTagCategory> store = new ArrayList<>();
            innerTagCategory.add(new innerTagCategory(tagCategory.getCategoryName(),store,tagCategory.getCategoryId()));
//            索取子标签的子标签
            getSonCategories(tagCategory.getCategoryId(), store);
        }
    }
}
