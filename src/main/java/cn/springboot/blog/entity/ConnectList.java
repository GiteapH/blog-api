package cn.springboot.blog.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConnectList implements Serializable {
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

    private String action;

    public ConnectList(Integer connectId, Integer principalUid, Integer subordinateUid,Integer weight,Date connectDate,String lastContent,Integer unreadNum,String action){
        this.connectDate = connectDate;
        this.connectId = connectId;
        this.principalUid = principalUid;
        this.lastContent = lastContent;
        this.subordinateUid = subordinateUid;
        this.weight = weight;
        this.unreadNum = unreadNum;
        this.action = action;
    }

    public ConnectList(){

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", connectId=").append(connectId);
        sb.append(", principalUid=").append(principalUid);
        sb.append(", subordinateUid=").append(subordinateUid);
        sb.append(", connectDate=").append(connectDate);
        sb.append(", weight=").append(weight);
        sb.append(", lastContent=").append(lastContent);
        sb.append(", unreadNum=").append(unreadNum);
        sb.append("]");
        return sb.toString();
    }
}