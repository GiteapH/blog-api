package cn.springboot.blog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/8/27 13:43
 */
@Data
public class ViewHistoryWithArticle {
    private Integer hId;

    private Integer hUid;

    /**
     * 历史记录类型 1文章
     *
     * @mbg.generated
     */
    private Byte hType;

    /**
     * 类型id
     *
     * @mbg.generated
     */
    private Integer hTId;

    /**
     * 浏览日期
     *
     * @mbg.generated
     */
    private Date hDate;

    /**
     * 1电脑
     *
     * @mbg.generated
     */
    private Byte hMachine;

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
        sb.append(", hId=").append(hId);
        sb.append(", hUid=").append(hUid);
        sb.append(", hType=").append(hType);
        sb.append(", hTId=").append(hTId);
        sb.append(", hDate=").append(hDate);
        sb.append(", hMachine=").append(hMachine);
        sb.append("]");
        return sb.toString();
    }
}
