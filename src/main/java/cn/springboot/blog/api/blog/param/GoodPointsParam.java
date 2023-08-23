package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodPointsParam implements Serializable {
    @ApiModelProperty("用户id")
    private Integer uid;

    @ApiModelProperty("typeId")
    private Integer id;

    @ApiModelProperty("操作的表：0 文章 1评论 2动态")
    private Integer tableType;


    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("更新类型")
    private Integer ntype;


}
