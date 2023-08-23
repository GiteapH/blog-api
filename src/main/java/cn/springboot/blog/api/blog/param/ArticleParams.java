package cn.springboot.blog.api.blog.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ArticleParams implements Serializable {
    @ApiModelProperty("文章内容")
    @NotEmpty(message = "文章内容不能为空")
    private String articles;

    @ApiModelProperty("个人标签")
    @NotEmpty(message = "个人标签不能为空")
    private String tagsPer;

    @ApiModelProperty("系统标签")
    @NotEmpty(message = "系统标签不能为空")
    private String tagsSys;

    @ApiModelProperty("文章简介")
    @NotEmpty(message = "文章简介不能为空")
    private String tinyMes;

    @ApiModelProperty("文章标题")
    @NotEmpty(message = "文章标题不能为空")
    private String title;

    @ApiModelProperty("文章id")
    private Integer aid;

    @ApiModelProperty("发表用户id")
    @NotEmpty(message = "发表用户id")
    private Integer uid;

    /**
     * 点赞数
     *
     * @mbg.generated
     */
    @ApiModelProperty("更新的喜欢数")
    private Integer like;

    /**
     * 点踩数
     *
     * @mbg.generated
     */
    @ApiModelProperty("更新的点踩数")
    private Integer dislike;

    /**
     * 评论数
     *
     * @mbg.generated
     */
    @ApiModelProperty("更新的评论数")
    private Integer comments;

    /**
     * 观看数
     *
     * @mbg.generated
     */
    @ApiModelProperty("更新的观看数")
    private Integer watched;

    /**
     * 收藏数
     *
     * @mbg.generated
     */
    @ApiModelProperty("更新的文章数")
    private Integer collected;

}
