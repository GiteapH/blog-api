package cn.springboot.blog.entity;

import java.io.Serializable;
import java.util.Date;

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

    private static final long serialVersionUID = 1L;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Byte getIsTopic() {
        return isTopic;
    }

    public void setIsTopic(Byte isTopic) {
        this.isTopic = isTopic;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}