package cn.springboot.blog.service;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.util.PageQueryUtil;

import java.util.*;
public interface DynamicService {
//    获取动态信息列表
//    uid 动态主 type 动态类型 。。。页码等
    List<Map<String,Object>> getDynamicInfo(PageQueryUtil pageQueryUtil);

    int insertDynamic(Dynamic dynamic);

    int updateParams(Dynamic dynamic);
}
