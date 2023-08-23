package cn.springboot.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class CommentAndUser implements Serializable {
    private Long id;

    private String email;

    private String username;

    private String password;

    private String head;

    private String cardimg;

    private Byte lockedflag;

    private Byte isdeleted;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String describe;

    /**
     * 评论id
     *
     * @mbg.generated
     */
    private Integer cid;

    /**
     * 文章发布者id
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
     * 评论者id
     *
     * @mbg.generated
     */
    private Integer fromUid;

    /**
     * 目标评论者id
     *
     * @mbg.generated
     */
    private Integer toUid;

    /**
     * 评论时间
     *
     * @mbg.generated
     */
    private Date date;

    /**
     * 上层评论id
     *
     * @mbg.generated
     */
    private Integer precid;

    /**
     * 评论类型
     *
     * @mbg.generated
     */
    private Integer cType;

    /**
     * 回鹘id
     *
     * @mbg.generated
     */
    private Integer replayCid;


    /**
     * 评论内容
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer goodUid;

    /**
     * 时间
     *
     * @mbg.generated
     */
    private Date time;

    /**
     * 点赞类型（评论，文章）
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * 评论id
     *
     * @mbg.generated
     */
    private Integer goodCid;

    /**
     * 文章id
     *
     * @mbg.generated
     */
    private Integer goodAid;

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", cid=" + cid +
                ", uid=" + uid +
                ", aid=" + aid +
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", date=" + date +
                ", precid=" + precid +
                ", content=" + content +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", email=" + email +
                ", username=" + username +
                ", password=" + password +
                ", head=" + head +
                ", cardimg=" + cardimg +
                ", lockedflag=" + lockedflag +
                ", isdeleted=" + isdeleted +
                ", createtime=" + createtime +
                "]";
        return sb;
    }
}