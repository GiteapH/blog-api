package cn.springboot.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DynamicAndUser {
    /**
     * 动态id
     *
     * @mbg.generated
     */
    private Integer did;

    /**
     * 动态发布者id
     *
     * @mbg.generated
     */
    private Integer dUid;

    /**
     * 动态图片,逗号分割
     *
     * @mbg.generated
     */
    private String dSrc;

    /**
     * 分享文章id
     *
     * @mbg.generated
     */
    private Integer dAid;

    /**
     * 发布时间
     *
     * @mbg.generated
     */
    private Date dDate;

    /**
     * 动态类型 0自主发布动态 1评论动态 2分享动态
     *
     * @mbg.generated
     */
    private Integer dType;

    /**
     * 动态内容
     *
     * @mbg.generatedt
     */
    private String dContent;

    /**
     * 允许评论类型 0允许评论 1禁止评论 2开启精选评论
     *
     * @mbg.generated
     */
    private Integer responseType;

    /**
     * 主题id
     *
     * @mbg.generated
     */
    private Integer topicId;

    private Integer comments;

    private Integer share;

    private Long id;

    private String email;

    private String username;

    private String password;

    private String head;

    private String cardimg;

    private Byte lockedflag;

    private Byte isdeleted;

    private Date createtime;

    private String describe;

    private String qq;



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", did=").append(did);
        sb.append(", dUid=").append(dUid);
        sb.append(", dSrc=").append(dSrc);
        sb.append(", dAid=").append(dAid);
        sb.append(", dDate=").append(dDate);
        sb.append(", dType=").append(dType);
        sb.append(", dContent=").append(dContent);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", head=").append(head);
        sb.append(", cardimg=").append(cardimg);
        sb.append(", lockedflag=").append(lockedflag);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", createtime=").append(createtime);
        sb.append(", qq=").append(qq);
        sb.append("]");
        return sb.toString();
    }
}
