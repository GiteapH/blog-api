package cn.springboot.blog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserFan implements Serializable {
    /**
     * 关注主键
     *
     * @mbg.generated
     */
    private Integer fid;

    /**
     * 粉丝用户id
     *
     * @mbg.generated
     */
    private Integer fUid;

    /**
     * 关注的up用户id
     *
     * @mbg.generated
     */
    private Integer fTouid;

    /**
    *@author 吕杨平
    *@Description
    *@Date 13:23 2023/1/28
    *@Param
    *@Return 判断是否互相关注
    */
    private boolean fanEach;

    /**
     * 关注时间
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fDate;

    /**
     * 关注列表类型
     *
     * @mbg.generated
     */
    private Byte fType;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getfUid() {
        return fUid;
    }

    public void setFanEach(boolean fanEach) {
        this.fanEach = fanEach;
    }

    public boolean getFanEach() {
        return fanEach;
    }
    public void setfUid(Integer fUid) {
        this.fUid = fUid;
    }

    public Integer getfTouid() {
        return fTouid;
    }

    public void setfTouid(Integer fTouid) {
        this.fTouid = fTouid;
    }

    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public Byte getfType() {
        return fType;
    }

    public void setfType(Byte fType) {
        this.fType = fType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fUid=").append(fUid);
        sb.append(", fTouid=").append(fTouid);
        sb.append(", fDate=").append(fDate);
        sb.append(", fType=").append(fType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}