package cn.springboot.blog.dao;

import cn.springboot.blog.entity.TagCategory;
import java.util.*;

public interface TagCategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(TagCategory row);

    int insertSelective(TagCategory row);

    List<TagCategory> selectALL();

    TagCategory selectByPrimaryKey(Long categoryId);

    Integer selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(TagCategory row);

    int updateByPrimaryKey(TagCategory row);

    List<TagCategory> getTagCategoriesByIds(List<String> ids);
    List<TagCategory> selectAllByCategoryByLevel(Integer level);
    List<TagCategory> selectAllByCategoryByParentId(Long pid);
}