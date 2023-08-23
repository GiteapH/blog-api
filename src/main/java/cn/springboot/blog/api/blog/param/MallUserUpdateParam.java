
package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户修改param
 */
@Data
public class MallUserUpdateParam implements Serializable {

    @ApiModelProperty("用户昵称")
    private String username;

    @ApiModelProperty("用户密码(需要MD5加密)")
    private String passwordMd5;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("描述")
    private String describe;

    @ApiModelProperty("背景卡片")
    private String cardImg;

    @ApiModelProperty("用户头像")
    private String head;

    @ApiModelProperty("原始EMAIL")
    private String originalEmail;

    @ApiModelProperty("qq号码")
    private String qq;
}
