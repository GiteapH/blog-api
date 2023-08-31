package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ViewHistory implements Serializable {
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