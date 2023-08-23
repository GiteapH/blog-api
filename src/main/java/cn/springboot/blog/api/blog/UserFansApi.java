package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.FanParams;
import cn.springboot.blog.api.blog.param.GroupParams;
import cn.springboot.blog.entity.UserAndFanned;
import cn.springboot.blog.entity.UserFan;
import cn.springboot.blog.service.MallUserService;
import cn.springboot.blog.service.UserFansService;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(value = "v1", tags = "关注系统接口文档")
@RequestMapping("/api/v1")
public class UserFansApi {
    @Autowired
    UserFansService userFansService;
    @Autowired
    MallUserService mallUserService;
    @PutMapping("/fan/putFan")
    public Result addFan(@RequestBody FanParams fanParams){
        return userFansService.addFan(fanParams.getToUid(), fanParams.getUid(), fanParams.getType());
    }

    @DeleteMapping("/fan/delFan")
    public Result delFan(@RequestParam Integer fid){
        try {
            int i = userFansService.delFan(fid);
            return ResultGenerator.genSuccessResult(i);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/fan/fanGroups")
    public Result getGroups(@RequestParam Integer loginUid){
        try {
            String[] fanGroups = mallUserService.getFanGroups(loginUid);
            return ResultGenerator.genSuccessResult(fanGroups);
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }

    }
//    获取关注列表
    @GetMapping("/fan/getLUFans")
    public Result getLoginUserFans(@RequestParam Integer type,
                                   @RequestParam Integer loginUid,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "15") Integer limit,
                                   @RequestParam Integer sortKey){
        try {
            Map<String,Object> pageMap = new HashMap<>();
            pageMap.put("page",page);
            pageMap.put("limit",limit);
            pageMap.put("sortKey",sortKey);
            pageMap.put("type",type==1?null:type);
            pageMap.put("loginUid",loginUid);
            List<UserAndFanned> allUserFanned = userFansService.getAllUserFanned(new PageQueryUtil(pageMap));
            int size = userFansService.getUserFanLen(loginUid,type==1?null:type);
            for(UserAndFanned userFan : allUserFanned){
                boolean contain = userFansService.fanEachOther(userFan.getFTouid(), loginUid,0)==1;
                userFan.setFanEach(contain);
                userFan.setSize(size);
            }
            return ResultGenerator.genSuccessResult(allUserFanned);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
//    获取粉丝列表
    @GetMapping("/fan/getLUfanList")
    public Result getLUfanList(@RequestParam Integer loginUid,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "15") Integer limit,
                               @RequestParam Integer sortKey){
        try {
            Map<String,Object> pageMap = new HashMap<>();
            pageMap.put("page",page);
            pageMap.put("limit",limit);
            pageMap.put("sortKey",sortKey);
            pageMap.put("loginUid",loginUid);
            List<UserAndFanned> allUserFanned = userFansService.getAllUserFansList(new PageQueryUtil(pageMap));
            int size = userFansService.getUserFanListLen(loginUid);
            for(UserAndFanned userFan : allUserFanned){
                System.err.println(userFan+" "+userFan.getFTouid()+" "+loginUid);
                boolean contain = userFansService.fanEachOther(userFan.getFUid(), loginUid,1)==1;
                userFan.setFanEach(contain);
                userFan.setSize(size);
            }
            return ResultGenerator.genSuccessResult(allUserFanned);
        }catch (Exception e) {
            e.printStackTrace(System.err);
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PutMapping("/fan/addGroup")
    public Result addGroup(@RequestBody GroupParams groupParams){
        int effect = mallUserService.addNewGroup(groupParams.getUid(), groupParams.getNewGroup());
        return ResultGenerator.genSuccessResult(effect);
    }

    @PutMapping("/fan/updateGroup")
    public Result updateGroup(@RequestParam Integer fid,@RequestParam Byte type){
        UserFan userFan = new UserFan();
        userFan.setfType(type);
        userFan.setFid(fid);
        int effect = userFansService.updateUserFan(userFan);
        if(effect==1)
            return ResultGenerator.genSuccessResult("更新成功");
        else return ResultGenerator.genErrorResult(500,"更新失败");
    }
}
