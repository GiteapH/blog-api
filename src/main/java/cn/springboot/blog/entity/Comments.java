package cn.springboot.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comments implements Serializable {

    /**
     * 评论id
     *
     * @mbg.generated
     */
    private Integer cid;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 上层评论id
     *
     * @mbg.generated
     */
    private Integer precid;

    /**
     * 评论内容
     *
     * @mbg.generated
     */
    private String content;


    private Integer replayCid;

    private Integer cType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", aid=").append(aid);
        sb.append(", fromUid=").append(fromUid);
        sb.append(", toUid=").append(toUid);
        sb.append(", date=").append(date);
        sb.append(", precid=").append(precid);
        sb.append(", replayCid=").append(replayCid);
        sb.append(", cType=").append(cType);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}