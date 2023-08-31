package cn.springboot.blog.dao;

import cn.springboot.blog.entity.SearchContent;
import java.util.*;
public interface SearchContentMapper {
    int deleteByPrimaryKey(Integer searchId);

    int insert(SearchContent row);

    int insertSelective(SearchContent row);

    List<SearchContent> selectAllMatch(String prefix);

    SearchContent selectByPrimaryKey(Integer searchId);

    SearchContent selectByContent(String content);

    int updateByPrimaryKeySelective(SearchContent row);

    int updateByPrimaryKeyWithBLOBs(SearchContent row);

    int updateByPrimaryKey(SearchContent row);
}