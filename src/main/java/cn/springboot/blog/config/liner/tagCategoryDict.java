package cn.springboot.blog.config.liner;

import cn.springboot.blog.entity.TagCategory;
import cn.springboot.blog.service.TagCategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/8/26 14:11
 */
@Component
@Order(value = 1)
public class tagCategoryDict implements CommandLineRunner {
    @Resource
    TagCategoryService tagCategoryService;

    public static Map<Long,String> tagCategoryMap= new ConcurrentHashMap<>();
    @Override
    public void run(String... args) throws Exception {
        System.err.println("_____________加载标签映射_____________");
        List<TagCategory> all = tagCategoryService.getAll();
        all.forEach((tagCategory -> {
            tagCategoryMap.put(tagCategory.getCategoryId(),tagCategory.getCategoryName());
        }));
    }
}
