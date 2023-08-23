package cn.springboot.blog.service;

import cn.springboot.blog.entity.UserModules;

import java.util.List;

public interface UserModuleService {
    List<String> getModulesById(Integer uid);

    int updateModules(UserModules modules);

    int resetUserModule(UserModules userModules);


}
