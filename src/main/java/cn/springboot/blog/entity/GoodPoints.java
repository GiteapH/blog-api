package cn.springboot.blog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodPoints implements Serializable {
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 点赞类型（评论，文章）
     *
     * @mbg.generated
     */
    private Integer type;

    private Integer ntype;

    /**
     * type 的 id
     *
     * @mbg.generated
     */
    private Integer goodId;

    private Integer tableType;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodUid=").append(goodUid);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append(", goodId=").append(goodId);
        sb.append("]");
        return sb.toString();
    }
}