package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    /**
     * 用户id
     *
     * @mbg.generated
     */
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

    /**
     * 不感兴趣的标签
     *
     * @mbg.generated
     */
    private String dislikeCategory;


    public UserInfo(Long uid){
        this.uid = uid;
    }

    public UserInfo(){

    };
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", fans=").append(fans);
        sb.append(", followers=").append(followers);
        sb.append(", collections=").append(collections);
        sb.append(", readers=").append(readers);
        sb.append(", comments=").append(comments);
        sb.append(", goods=").append(goods);
        sb.append(", submits=").append(submits);
        sb.append(", interviewer=").append(interviewer);
        sb.append(", gender=").append(gender);
        sb.append("]");
        return sb.toString();
    }
}