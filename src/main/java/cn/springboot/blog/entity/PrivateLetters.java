package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class PrivateLetters implements Serializable {
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


    public PrivateLetters(String content,Date date,Integer fromUid,Integer toId){
        this.content = content;
        this.sendTime = date;
        this.fromUid = fromUid;
        this.toId = toId;
    }

    public PrivateLetters(){

    }
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
        sb.append("]");
        return sb.toString();
    }
}