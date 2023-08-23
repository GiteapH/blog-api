package cn.springboot.blog.api.blog.param;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConnectListParams implements Serializable {
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

}
