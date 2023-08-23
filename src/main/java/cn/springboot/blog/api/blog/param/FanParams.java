package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class FanParams implements Serializable {
    @ApiModelProperty("up主id")
    @NotEmpty(message = "up的id不能为空")
    private Integer toUid;
    @ApiModelProperty("用户id")
    @NotEmpty(message = "用户id不为空")
    private Integer uid;
    @ApiModelProperty("关注类型")
    @Value("0")
    private Byte type;
}
