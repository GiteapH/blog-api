
package cn.springboot.blog.service;

import cn.springboot.blog.api.blog.param.MallUserUpdateParam;
import cn.springboot.blog.entity.UserInfo;
import cn.springboot.blog.entity.UserInfoAndRegisterInfo;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.PageResult;
import com.alibaba.dubbo.container.page.Page;

import java.util.*;

public interface MallUserService {


    String[] getFanGroups(Integer uid);

    int addNewGroup(Integer uid, String newGroup);

    /**
     * 登录
     *
     * @param loginName
     * @param passwordMD5
     * @return
     */
    String login(String loginName, String passwordMD5);

    /**
     * 用户信息修改
     *
     * @param mallUser
     * @return
     */
    int updateUserInfo(MallUserUpdateParam mallUser);

    /**
     * 登出接口
     * @param userId
     * @return
     */
    Boolean logout(Long userId);

    UserInfoAndRegisterInfo selectUserInfoById(Long id);

    UserInfo resetUserInfo(UserInfo userInfo);

    int getUsersLen(PageQueryUtil pageQueryUtil);


    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getMallUsersPage(PageQueryUtil pageUtil);


    List<UserInfoAndRegisterInfo> getUsers(PageQueryUtil pageQueryUtil);

}
