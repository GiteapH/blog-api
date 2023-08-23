package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class DynamicParams implements Serializable {

    /**
     * 动态发布者id
     *
     * @mbg.generated
     */
    @ApiModelProperty("动态发布者id")
    @NotEmpty(message = "动态发布者id不能为空")
    private Integer dUid;

    /**
     * 分享文章id
     *
     * @mbg.generated
     */
    @ApiModelProperty("分享文章id")
    @NotEmpty(message = "分享文章id不能为空")
    private Integer dAid;

    /**
     * 发布时间
     *
     * @mbg.generated
     */
    @ApiModelProperty("发布时间")
    @NotEmpty(message = "发布时间不能为空")
    private Date dDate;

    /**
     * 动态类型 0自主发布动态 1评论动态 2分享动态
     *
     * @mbg.generated
     */
    @ApiModelProperty("动态类型")
    @NotEmpty(message = "动态类型不能为空")
    private Integer dType;

    /**
     * 动态图片,逗号分割
     *
     * @mbg.generated
     */
    @ApiModelProperty("图片路径")
    private String dSrc;

    /**
     * 动态内容
     *
     * @mbg.generated
     */
    @ApiModelProperty("动态内容")
    @NotEmpty(message = "动态内容不能为空")
    private String dContent;

    /**
     * 允许评论类型 0允许评论 1禁止评论 2开启精选评论
     *
     * @mbg.generated
     */
    @ApiModelProperty("评论权限")
    @NotEmpty(message = "评论权限不能为空")
    private Integer responseType;

    /**
     * 主题id
     *
     * @mbg.generated
     */
    private Integer topicId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dUid=").append(dUid);
        sb.append(", dAid=").append(dAid);
        sb.append(", dDate=").append(dDate);
        sb.append(", dType=").append(dType);
        sb.append(", responseType=").append(responseType);
        sb.append(", dSrc=").append(dSrc);
        sb.append(", topicId=").append(topicId);
        sb.append(", dContent=").append(dContent);
        sb.append("]");
        return sb.toString();
    }
}
