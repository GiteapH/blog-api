package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConnectAndUser implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Integer connectId;

    /**
     * 主
     *
     * @mbg.generated
     */
    private Integer principalUid;

    /**
     * 从
     *
     * @mbg.generated
     */
    private Integer subordinateUid;

    /**
     * 开启聊天时间
     *
     * @mbg.generated
     */
    private Date connectDate;

    /**
     * 权重
     *
     * @mbg.generated
     */
    private Integer weight;

    /**
     * 最新记录
     *
     * @mbg.generated
     */
    private String lastContent;

    /**
     * 未读消息
     *
     * @mbg.generated
     */
    private Integer unreadNum;

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
}
