
package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.MallUserLoginParam;
import cn.springboot.blog.api.blog.param.MallUserRegisterParam;
import cn.springboot.blog.api.blog.param.MallUserUpdateParam;
import cn.springboot.blog.api.blog.param.UserCheckParam;
import cn.springboot.blog.api.blog.vo.LoginResult;
import cn.springboot.blog.api.blog.vo.MallUserVO;
import cn.springboot.blog.common.Constants;
import cn.springboot.blog.config.annotation.TokenToMallUser;
import cn.springboot.blog.dao.UsersMapper;
import cn.springboot.blog.entity.*;
import cn.springboot.blog.service.*;
import cn.springboot.blog.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@Api(value = "v1", tags = "用户操作相关接口")
@RequestMapping("/api/v1")
public class MallPersonalAPI {
    @Resource
    private MallUserService mallUserService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserModuleService userModuleService;
    @Autowired
    private UserClockService clockService;

    @Autowired
    private ConnectListService connectListService;

    @Autowired
    UserFansService userFansService;
    private static final Logger logger = LoggerFactory.getLogger(MallPersonalAPI.class);

    @PostMapping("/user/login")
    @ApiOperation(value = "登录接口", notes = "返回token+用户信息")
    public Result<String> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam) {
        String loginResult = mallUserService.login(mallUserLoginParam.getLoginName(), mallUserLoginParam.getPasswordMd5());
        logger.info("login api,loginName={},loginResult={}", mallUserLoginParam.getLoginName(), loginResult);

        //登录成功
        if (!StringUtils.isEmpty(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH) {
            Result result = ResultGenerator.genSuccessResult();
            Users user = usersMapper.selectByLoginNameAndPasswd(mallUserLoginParam.getLoginName(), mallUserLoginParam.getPasswordMd5());
            LoginResult res = new LoginResult();
            res.setInfo(user);
            res.setToken(loginResult);
            result.setData(res);
            return result;
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }


    @GetMapping("/user/login2up")
    @ApiOperation(value = "用户与up的关联修仙")
    public Result login2up(Integer upUid,Integer loginUid){
//        关注信息
        UserFan userFan;
        try {
            userFan = userFansService.checkLoginUserIsFan(upUid, loginUid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("fanRelation",userFan);
        return ResultGenerator.genSuccessResult(map);

    }

    @PostMapping("/user/register")
    @ApiOperation(value = "注册接口")
    public Result<String> register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam) {
        Users users = usersMapper.selectByEmail(mallUserRegisterParam.getEmail());
        String loginResult = "";
        if(users!=null){
            logger.info("login api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), loginResult);
            return ResultGenerator.genFailResult("该邮箱已存在");
        }
        logger.info("login api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), loginResult);

        Users newUser = new Users();
        newUser.setPassword(mallUserRegisterParam.getPassword());
        newUser.setUsername(mallUserRegisterParam.getLoginName());
        newUser.setEmail(mallUserRegisterParam.getEmail());
        int insert = usersMapper.insertSelective(newUser);
        if(insert!=0){
//            初始化基本信息表
            try {
                mallUserService.resetUserInfo(new UserInfo(newUser.getId()));
//            初始化模块表
                userModuleService.resetUserModule(new UserModules(Math.toIntExact(newUser.getId())));
//            初始化用户进程表
                clockService.resetUserClock(new UserClock(Math.toIntExact(newUser.getId()),"刚刚加入网站",new Date()));
//            设置系统回复
                connectListService.insertConnectList(new ConnectList(null, Math.toIntExact(newUser.getId()), 0, 0, new Date(), null, null,null));
            }catch (Exception e){
                e.printStackTrace();
                return ResultGenerator.genFailResult(e.getMessage());
            }
            return ResultGenerator.genSuccessResult("注册成功");
        }
        //登录失败
        return ResultGenerator.genFailResult("注册失败");
    }
    @PostMapping("/user/checkContain")
    @ApiOperation(value = "检查接口")
    public Result<String> checkContain(@RequestBody UserCheckParam userCheckParam) {
        Users users = usersMapper.selectByEmail(userCheckParam.getLoginName());
        String loginResult = "";
        if(users!=null){
            logger.info("login api,loginName={},loginResult={}", userCheckParam.getLoginName(), loginResult);
            return ResultGenerator.genSuccessResult(users);
        }

        else{
            return ResultGenerator.genFailResult("不存在");
        }

    }


    @PostMapping("/user/logout")
    @ApiOperation(value = "登出接口", notes = "清除token")
    public Result<String> logout(@TokenToMallUser Users loginMallUser) {
        Boolean logoutResult = mallUserService.logout(loginMallUser.getId());

        logger.info("logout api,loginMallUser={}", loginMallUser.getId());

        //登出成功
        if (logoutResult) {
            return ResultGenerator.genSuccessResult();
        }
        //登出失败
        return ResultGenerator.genFailResult("logout error");
    }




    @PutMapping("/user/info")
    @ApiOperation(value = "修改用户信息", notes = "")
    public Result updateInfo(@RequestBody @ApiParam("用户信息") MallUserUpdateParam mallUserUpdateParam) {
        int res = mallUserService.updateUserInfo(mallUserUpdateParam);
        Result result;
        if (res==1) {
            //返回成功
            result = ResultGenerator.genSuccessResult("修改成功");
        } else {
            switch (res){
                case -1:
                    result = ResultGenerator.genFailResult("修改失败");
                    break;
                case -2:
                    result = ResultGenerator.genFailResult("新邮箱已被注册");
                    break;
                default:
                    result = ResultGenerator.genFailResult("服务器发送异常");
            }

        }
        return result;
    }

    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result<MallUserVO> getUserDetail(@TokenToMallUser UserInfoAndRegisterInfo loginMallUser) {
        //已登录则直接返回
        return ResultGenerator.genSuccessResult(loginMallUser);
    }
    @GetMapping("/user/infoBIs")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result getUserDetailById(@RequestParam String uids,@RequestParam(defaultValue = "15") Integer limit,@RequestParam(defaultValue = "1") Integer start) {
        Map<String,Object> map = new HashMap<>();

        map.put("uids",uids.split(","));
        map.put("limit",limit);
        map.put("page",start);
        PageResult mallUsersPage = null;
        try {
            mallUsersPage = mallUserService.getMallUsersPage(new PageQueryUtil(map));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genErrorResult(500,e.getMessage());
        }
        return ResultGenerator.genSuccessResult(mallUsersPage);
    }

    @GetMapping("/user/getUsers")
    @ApiOperation(value = "获取用户列表", notes = "")
    public Result getUsers2Article(@RequestParam(required = false,defaultValue = "0") @ApiParam(value = "排序依据") Integer orderPath,
                                   @RequestParam(required = false,defaultValue = "1") @ApiParam(value = "页码") Integer pageNumber,
                                   @RequestParam(required = false) @ApiParam(value = "关键字") String key,
                                   @RequestParam(required = false) @ApiParam(value = "登录id") Integer loginUid){
        Map<String, Object> store = new HashMap<>();
        store.put("page",pageNumber);
        store.put("limit",15);
        store.put("orderName", SystemUtil.getUserOrderName(orderPath));
        store.put("key", key);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(store);
        List<UserInfoAndRegisterInfo> users = mallUserService.getUsers(pageQueryUtil);
        int usersLen = mallUserService.getUsersLen(pageQueryUtil);
        store.clear();
        store.put("list",users);
        store.put("size",usersLen);
        if(loginUid!=null) {
            for (UserInfoAndRegisterInfo userInfoAndRegisterInfo : users) {
                userInfoAndRegisterInfo.setFanItem(userFansService.fanEachOther(Math.toIntExact(userInfoAndRegisterInfo.getId()), loginUid, 1)==1);
            }
        }
        return ResultGenerator.genSuccessResult(store);

    }
}
