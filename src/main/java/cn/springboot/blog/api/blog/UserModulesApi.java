package cn.springboot.blog.api.blog;

import cn.springboot.blog.entity.UserModules;
import cn.springboot.blog.service.UserModuleService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import cn.springboot.blog.util.SystemUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;

@RestController
@Api(value = "v1", tags = "用户模块操作接口")
@RequestMapping("/api/v1")
public class UserModulesApi {

    @Autowired
    UserModuleService userModuleService;

    @GetMapping("/modules/getUMs")
    public Result getUerModules(@RequestParam Integer uid){
        try {
            Set<String> modules = new HashSet<>(userModuleService.getModulesById(uid));
            String[] moduleNames = SystemUtil.getModuleNames();
            Map<String,Object> resMap =  new HashMap<>();
            for(int i=0;i<moduleNames.length;i++){
                Map<String, Object> name_checked = new HashMap<>();
                name_checked.put("name",moduleNames[i]);
                name_checked.put("checked",modules.contains(moduleNames[i]));
                name_checked.put("key",i);
                resMap.put(moduleNames[i],name_checked);
            }
            return ResultGenerator.genSuccessResult(resMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500,e.getMessage());
        }
    }

    @PutMapping("/modules/UDMdoules")
    public Result updateModules(@RequestParam Integer uid,@RequestParam String modules){
        UserModules userModules = new UserModules();
        userModules.setUid(uid);
        userModules.setOpenModules(modules);
        int effect = userModuleService.updateModules(userModules);
        if(effect==1){
            return ResultGenerator.genSuccessResult("更新成功");
        }else{
            return ResultGenerator.genFailResult("更新失败");
        }
    }
}
