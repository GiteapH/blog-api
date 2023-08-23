package cn.springboot.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCode implements Serializable {
    private String email;

    private String code;

    private Date expireTime;

    private Date updateTime;



    private static final long serialVersionUID = 1L;

    public UserCode(Date expire_date, Date date, String email, String code) {
        this.email=email;
        this.expireTime = expire_date;
        this.updateTime = date;
        this.code = code;
    }

    public UserCode(){}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", email=").append(email);
        sb.append(", code=").append(code);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}