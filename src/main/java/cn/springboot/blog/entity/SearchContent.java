package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchContent implements Serializable {
    /**
     * 搜索内容id
     *
     * @mbg.generated
     */
    private Integer searchId;

    /**
     * 优先级
     *
     * @mbg.generated
     */
    private Integer priority;

    /**
     * 是否主题
     *
     * @mbg.generated
     */
    private Byte isTopic;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date searchDate;

    /**
     * 搜索内容
     *
     * @mbg.generated
     */
    private String searchContent;


    public SearchContent() {

    }

    public SearchContent(String content) {
        this.searchContent = content;
        this.searchDate = new Date();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", searchId=").append(searchId);
        sb.append(", priority=").append(priority);
        sb.append(", isTopic=").append(isTopic);
        sb.append(", searchDate=").append(searchDate);
        sb.append(", searchContent=").append(searchContent);
        sb.append("]");
        return sb.toString();
    }
}