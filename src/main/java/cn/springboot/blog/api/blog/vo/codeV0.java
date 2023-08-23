package cn.springboot.blog.api.blog.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class codeV0 implements Serializable {
    @ApiModelProperty("验证码")
    private String code;


    @ApiModelProperty("用户id")
    private int uid = -1;
}
