package cn.springboot.blog.dao;

import cn.springboot.blog.entity.LetterAndUser;
import cn.springboot.blog.entity.PrivateLetters;
import java.util.*;
public interface PrivateLettersMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(PrivateLetters row);

    int insertSelective(PrivateLetters row);

    PrivateLetters selectByPrimaryKey(Integer lid);

    List<LetterAndUser> selectAllLetters(Integer fromUid,Integer toUid);

    int updateByPrimaryKeySelective(PrivateLetters row);

    int updateByPrimaryKey(PrivateLetters row);
}