package cn.springboot.blog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserAndFanned {

    private Integer fid;

    private Integer fTouid;

    private Integer fUid;

    private boolean fanEach;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fDate;

    private Byte fType;

    //    user
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

    private int size;

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
        sb.append(", name=").append(username);
        sb.append("]");
        return sb.toString();
    }
}
