package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.MailParams;
import cn.springboot.blog.api.blog.vo.codeV0;
import cn.springboot.blog.service.MailService;
import cn.springboot.blog.service.UserCodeService;
import cn.springboot.blog.service.impl.MailServiceImpl;
import cn.springboot.blog.util.MailUtil;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@Api(value = "v1", tags = "邮箱发送接口")
@RequestMapping("/api/v1")
public class MailSendApi {
    @Autowired
    private MailService mailService;

    @Autowired
    private UserCodeService userCodeService;



    @PostMapping("/user/sendMail")
    @ApiOperation(value = "发送邮件接口")
    public Result<String> send(@RequestBody @Valid MailParams mailParams) {
        String code = MailUtil.get6Code();
        String htmlContent = MailUtil.getHtmlContent(code, mailParams.getAction(), mailParams.getUsername());
        try {
            mailService.sendMimeMessage(mailParams.getToMail(),mailParams.getAction(),htmlContent);
            boolean insertSuccess = userCodeService.insertUserCode(code, mailParams.getEmail());
            if(insertSuccess)
                return ResultGenerator.genSuccessResult("发送成功");
        } catch (MessagingException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }

        return ResultGenerator.genFailResult("验证码因异常失效");
    }

    @PostMapping("/user/checkCode/{code}/{email}")
    @ApiOperation(value = "验证接口")
    public Result<String> send(@PathVariable(value = "code",required = true) String code,@PathVariable("email") String email) {
        Result<String> result = mailService.checkCode(code, email);
        return result;
    }
}
