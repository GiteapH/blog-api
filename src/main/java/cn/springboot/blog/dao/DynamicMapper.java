package cn.springboot.blog.dao;

import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.entity.DynamicAndUser;
import cn.springboot.blog.util.PageQueryUtil;

import java.util.*;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Dynamic row);

    int insertSelective(Dynamic row);

    List<DynamicAndUser> selectAllByDUid(PageQueryUtil pageQueryUtil);

    Dynamic selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Dynamic row);

    int updateByPrimaryKeyWithBLOBs(Dynamic row);

    int updateByPrimaryKey(Dynamic row);
}