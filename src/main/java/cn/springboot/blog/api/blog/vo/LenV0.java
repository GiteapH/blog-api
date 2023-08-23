package cn.springboot.blog.api.blog.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LenV0 {
    @ApiModelProperty("数据量")
    private long len;

}
