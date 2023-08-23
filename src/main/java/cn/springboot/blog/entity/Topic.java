package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Topic implements Serializable {
    /**
     * 话题id
     *
     * @mbg.generated
     */
    private Integer tid;

    /**
     * 话题内容
     *
     * @mbg.generated
     */
    private String tTopic;

    /**
     * 发布时间
     *
     * @mbg.generated
     */
    private Date tDate;

    /**
     * 发布者
     *
     * @mbg.generated
     */
    private Integer tUid;

    /**
     * 参与者数量
     *
     * @mbg.generated
     */
    private Integer tPartake;

    /**
     * 浏览量
     *
     * @mbg.generated
     */
    private Long tVisit;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", tTopic=").append(tTopic);
        sb.append(", tDate=").append(tDate);
        sb.append(", tUid=").append(tUid);
        sb.append(", tPartake=").append(tPartake);
        sb.append(", tVisit=").append(tVisit);
        sb.append("]");
        return sb.toString();
    }
}