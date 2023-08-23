package cn.springboot.blog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class Articles implements Serializable {
    /**
     * 上传者id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 文章id
     *
     * @mbg.generated
     */
    private Integer aid;

    /**
     * 发布日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 点赞数
     *
     * @mbg.generated
     */
    private Integer like;

    /**
     * 点踩数
     *
     * @mbg.generated
     */
    private Integer dislike;

    /**
     * 评论数
     *
     * @mbg.generated
     */
    private Integer comments;

    /**
     * 观看数
     *
     * @mbg.generated
     */
    private Integer watched;

    /**
     * 收藏数
     *
     * @mbg.generated
     */
    private Integer collected;

    /**
     * 文章标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 文章内容
     *
     * @mbg.generated
     */
    private String articles;

    /**
     * 文章类别，用户自定义
     *
     * @mbg.generated
     */
    private String classper;

    /**
     * 文章类别，系统定义
     *
     * @mbg.generated
     */
    private String classsys;

    /**
     * 简介
     *
     * @mbg.generated
     */
    private String tinymes;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", aid=").append(aid);
        sb.append(", date=").append(date);
        sb.append(", like=").append(like);
        sb.append(", comments=").append(comments);
        sb.append(", watched=").append(watched);
        sb.append(", collected=").append(collected);
        sb.append(", title=").append(title);
        sb.append(", articles=").append(articles);
        sb.append(", classper=").append(classper);
        sb.append(", classsys=").append(classsys);
        sb.append(", tinymes=").append(tinymes);
        sb.append(", dislike=").append(dislike);
        sb.append("]");
        return sb.toString();
    }
}