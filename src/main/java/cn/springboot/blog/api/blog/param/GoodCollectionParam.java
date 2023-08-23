package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class GoodCollectionParam implements Serializable {
    @ApiModelProperty("用户id")
    private Integer uid;

    @ApiModelProperty("文章id")
    private Integer aid;
}
