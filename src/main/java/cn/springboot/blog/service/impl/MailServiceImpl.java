package cn.springboot.blog.service.impl;


import cn.springboot.blog.service.MailService;
import cn.springboot.blog.service.UserCodeService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 邮件服务
 * @author cc
 * @date 2021-12-07 10:37
 */
@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Autowired
    private UserCodeService userCodeService;
    private String SENDER;

    {
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setPassword("DTADZPWJPBXQRBTU");
            javaMailSender.setHost("smtp.163.com");
            javaMailSender.setUsername("lyp057403@163.com");
            javaMailSender.setPort(465);
            javaMailSender.setDefaultEncoding("UTF-8");
            javaMailSender.setProtocol("smtps");
            this.mailSender = javaMailSender;
            InputStream resourceAsStream = MailServiceImpl.class.getResourceAsStream("/application.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            this.SENDER = properties.getProperty("spring.mail.username");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    // 发送普通邮件
    public void sendSimpleMailMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(SENDER);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    // 发送html邮件
    public void sendMimeMessage(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();;
        // true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(SENDER);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    // 发送带附件的邮件
    public void sendMimeMessage(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();;
        // true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(SENDER);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }

    // 发送带静态文件的邮件
    public void sendMimeMessage(String to, String subject, String content, Map<String,String> rscIdMap) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        // true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(SENDER);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        for (Map.Entry<String, String> entry : rscIdMap.entrySet()) {
            FileSystemResource file = new FileSystemResource(new File(entry.getValue()));
            helper.addInline(entry.getKey(), file);
        }
        mailSender.send(message);
    }

    public Result checkCode(String code, String email){
        int truth = userCodeService.checkCode(code,email);
        if(truth==-1){
            return ResultGenerator.genFailResult( "请先获取验证码");
        }
        if(truth==2){
            return ResultGenerator.genFailResult("验证码已过期");
        }
        return truth==1?ResultGenerator.genSuccessResult("验证通过"):ResultGenerator.genFailResult("验证码错误");
    }

}


