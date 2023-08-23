package cn.springboot.blog.api.blog.vo;

import cn.springboot.blog.entity.Users;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginResult {
    @ApiModelProperty("token")
    String token;

    @ApiModelProperty("信息")
    Users info;
}
