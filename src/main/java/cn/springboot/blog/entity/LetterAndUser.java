package cn.springboot.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LetterAndUser {
    private Integer lid;

    /**
     * 推文标志
     *
     * @mbg.generated
     */
    private Byte isPush;

    /**
     * 推送表
     *
     * @mbg.generated
     */
    private String pushTable;

    /**
     * 推文id
     *
     * @mbg.generated
     */
    private Integer pushId;

    /**
     * 消息内容
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 发送方
     *
     * @mbg.generated
     */
    private Integer fromUid;

    /**
     * 接收方
     *
     * @mbg.generated
     */
    private Integer toId;

    /**
     * 发送时间
     *
     * @mbg.generated
     */
    private Date sendTime;
    /**
     * 提问方标志
     *
     * @mbg.generated
     */

    private boolean isSender;

    private Object pushContent;

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
        sb.append(", lid=").append(lid);
        sb.append(", isPush=").append(isPush);
        sb.append(", pushTable=").append(pushTable);
        sb.append(", pushId=").append(pushId);
        sb.append(", content=").append(content);
        sb.append(", fromUid=").append(fromUid);
        sb.append(", toId=").append(toId);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", head=").append(head);
        sb.append(", cardimg=").append(cardimg);
        sb.append(", lockedflag=").append(lockedflag);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", createtime=").append(createtime);
        sb.append(", qq=").append(qq);
        sb.append("]");
        return sb.toString();
    }
}
