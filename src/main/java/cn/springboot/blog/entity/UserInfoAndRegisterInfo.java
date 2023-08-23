package cn.springboot.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoAndRegisterInfo {
    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 用户qq
     *
     * @mbg.generated
     */
    private String qq;

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
     * 性别
     * 0 男
     * 1 女
     * 2 机器人
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     * 感兴趣的标签(category_id,逗号分隔)
     *
     * @mbg.generated
     */
    private String likeCategory;

    private Boolean fanItem;

    /**
     * 不感兴趣的标签
     *
     * @mbg.generated
     */
    private String dislikeCategory;

    private String email;

    private String username;

    private String password;

    private String head;

    private String cardimg;

    private Byte lockedflag;

    private Byte isdeleted;

    private Date createtime;

    private String describe;

}
