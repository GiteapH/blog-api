package cn.springboot.blog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class GoodCollections implements Serializable {
    /**
     * 收藏主键
     *
     * @mbg.generated
     */
    private Integer collectId;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer goodUid;

    /**
     * 收藏时间
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 文章id
     *
     * @mbg.generated
     */
    private Integer goodAid;

    private static final long serialVersionUID = 1L;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getGoodUid() {
        return goodUid;
    }

    public void setGoodUid(Integer goodUid) {
        this.goodUid = goodUid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getGoodAid() {
        return goodAid;
    }

    public void setGoodAid(Integer goodAid) {
        this.goodAid = goodAid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collectId=").append(collectId);
        sb.append(", goodUid=").append(goodUid);
        sb.append(", time=").append(time);
        sb.append(", goodAid=").append(goodAid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}