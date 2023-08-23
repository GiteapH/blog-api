
package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 用户注册param
 */
@Data
public class MallUserRegisterParam implements Serializable {

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("用户邮箱")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("描述")
    private String describe = "您暂未设置介绍，请前往个人中心设置。";

    @ApiModelProperty("背景卡片")
    private String cardImg;

    @ApiModelProperty("用户头像")
    private String head;
}
