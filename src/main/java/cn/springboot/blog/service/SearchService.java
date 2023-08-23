package cn.springboot.blog.service;

import cn.springboot.blog.entity.SearchContent;

import java.util.*;
public interface SearchService {
    List<SearchContent> getSearchSentence(String key);
}
