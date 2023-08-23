package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Users implements Serializable {
    private Long id;

    private String email;

    private String username;

    private String password;

    private String head;

    private String cardimg;

    private Byte lockedflag;

    private Byte isdeleted;

    private Date createtime;

    private String describe;

    private String qq;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", head=").append(head);
        sb.append(", cardimg=").append(cardimg);
        sb.append(", lockedflag=").append(lockedflag);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", createtime=").append(createtime);
        sb.append(", describe=").append(describe);
        sb.append(", qq=").append(qq);
        sb.append("]");
        return sb.toString();
    }
}