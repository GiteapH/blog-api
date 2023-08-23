package cn.springboot.blog.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Date;
@Data
public class Dynamic implements Serializable {
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
     * @mbg.generated
     */
    private String dContent;

    /**
     * 允许评论类型 0允许评论 1禁止评论 2开启精选评论
     *
     * @mbg.generated
     */
    private Integer responseType;

    private Integer comments;

    private Integer share;

    /**
     * 主题id
     *
     * @mbg.generated
     */
    private Integer topicId;


    public Dynamic(){

    }


    public Dynamic(Integer comments,Integer share,Integer did){
        this.comments = comments;
        this.share = share;
        this.did = did;
    }
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
        sb.append(", responseType=").append(responseType);
        sb.append("]");
        return sb.toString();
    }
}