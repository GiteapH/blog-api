package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class GroupParams implements Serializable {
    @ApiModelProperty("组别名称")
    @NotEmpty(message = "组别名称不能为空")
    private String newGroup;

    @ApiModelProperty("用户id")
    @NotEmpty(message = "用户id不能为空")
    private Integer uid;
}
