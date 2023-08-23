package cn.springboot.blog.api.blog.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class MailParams  implements Serializable {
    @ApiModelProperty("收件人邮箱")
    @NotEmpty(message = "收件人邮箱不能为空")
    private String toMail;

    @ApiModelProperty("发送动作")
    @NotEmpty(message = "发送动作不能为空")
    private String action;

    @ApiModelProperty("触发用户名")
    private String username;

    @ApiModelProperty("发送用户邮箱")
    private String email;
}
