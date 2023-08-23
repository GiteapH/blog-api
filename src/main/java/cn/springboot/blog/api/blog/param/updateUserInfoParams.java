package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class updateUserInfoParams implements Serializable {
    private Long uid;

    /**
     * 粉丝量
     *
     * @mbg.generated
     */
    private Integer fans;

    /**
     * 关注数
     *
     * @mbg.generated
     */
    private Integer followers;

    /**
     * 收藏数量
     *
     * @mbg.generated
     */
    private Integer collections;

    /**
     * 阅读数
     *
     * @mbg.generated
     */
    private Integer readers;

    /**
     * 被评论数
     *
     * @mbg.generated
     */
    private Integer comments;

    /**
     * 点赞数
     *
     * @mbg.generated
     */
    private Integer goods;

    /**
     * 发布数
     *
     * @mbg.generated
     */
    private Integer submits;

    /**
     * 被访问数
     *
     * @mbg.generated
     */
    private Integer interviewer;

    /**
     * 感兴趣的标签(category_id,逗号分隔)
     *
     * @mbg.generated
     */
    private String likeCategory;

    /**
     * 不感兴趣的标签
     *
     * @mbg.generated
     */
    private String dislikeCategory;

    /**
     * 性别
     * 0 男
     * 1 女
     * 2 机器人
     *
     * @mbg.generated
     */
    private Integer gender;

}
