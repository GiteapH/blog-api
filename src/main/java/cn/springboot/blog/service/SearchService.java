package cn.springboot.blog.service;

import cn.springboot.blog.entity.SearchContent;

import java.util.*;
public interface SearchService {
    List<SearchContent> getSearchSentence(String key);

    SearchContent getSearchContent(String content);

    int updateSearchSentence(SearchContent searchContent);

    int insertSearchSentence(SearchContent searchContent);

}
