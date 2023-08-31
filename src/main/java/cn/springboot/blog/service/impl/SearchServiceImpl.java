package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.SearchContentMapper;
import cn.springboot.blog.entity.SearchContent;
import cn.springboot.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchContentMapper searchContentMapper;
    /**
     * @param prefix 前缀关键字
     * @return
     */

    @Override
    public List<SearchContent> getSearchSentence(String prefix) {
        return searchContentMapper.selectAllMatch(prefix);
    }

    /**
     * @param content
     * @return
     */
    @Override
    public SearchContent getSearchContent(String content) {
        return searchContentMapper.selectByContent(content);
    }

    /**
     * @param searchContent
     * @return
     */
    @Override
    public int updateSearchSentence(SearchContent searchContent) {
        return searchContentMapper.updateByPrimaryKeySelective(searchContent);
    }

    /**
     * @param searchContent
     * @return
     */
    @Override
    public int insertSearchSentence(SearchContent searchContent) {
        return searchContentMapper.insertSelective(searchContent);
    }
}
