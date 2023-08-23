package cn.springboot.blog.service;

import cn.springboot.blog.util.Result;

import javax.mail.MessagingException;
import java.util.Map;

public interface MailService {
    void sendMimeMessage(String to, String subject, String content, Map<String,String> rscIdMap) throws MessagingException;

    Result checkCode(String code, String email);

    void sendMimeMessage(String to, String subject, String content, String filePath) throws MessagingException;

    void sendMimeMessage(String to, String subject, String content) throws MessagingException;


}
