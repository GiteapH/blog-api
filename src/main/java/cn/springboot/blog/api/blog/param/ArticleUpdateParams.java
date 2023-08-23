package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
public class ArticleUpdateParams implements Serializable {


//    递减字段
    @ApiModelProperty("{" +
            "0:点赞," +
            "1:点踩," +
            "2:收藏," +
            "3:评论," +
            "4：观看" +
            "}")
    Integer oldParamName;

//    递增字段
    Integer newParamName;

//    主键id
    Integer aid;
}
