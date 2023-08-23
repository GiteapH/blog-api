package cn.springboot.blog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserClock implements Serializable {
    /**
     * 用户打卡id
     *
     * @mbg.generated
     */
    private Integer kid;

    /**
     * 打卡日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clockDate;

    /**
     * 1打卡事件 事件类型，逗号分割 例如：发表文章 0,修改密码 1。
     * 
     * 0 基本
     * 1 安全
     * 2 失败
     *
     * @mbg.generated
     */
    private String event;

    private Integer uid;

    public UserClock(Integer uid,String event,Date date){
        this.uid = uid;
        this.clockDate = date;
        this.event = event;
    }

    public UserClock(){}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", kid=").append(kid);
        sb.append(", clockDate=").append(clockDate);
        sb.append(", event=").append(event);
        sb.append("]");
        return sb.toString();
    }
}