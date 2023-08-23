package cn.springboot.blog.dao;

import cn.springboot.blog.entity.TagCategory;
import java.util.*;

public interface TagCategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(TagCategory row);

    int insertSelective(TagCategory row);

    TagCategory selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(TagCategory row);

    int updateByPrimaryKey(TagCategory row);

    List<TagCategory> selectAllByCategoryByLevel(Integer level);
    List<TagCategory> selectAllByCategoryByParentId(Long pid);
}