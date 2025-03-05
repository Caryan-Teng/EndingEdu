package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.service.EmailPassSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author Caryan
 * @date 2025/3/5 13:50
 */
@Service
public class EmailPassSenderServiceImpl implements EmailPassSenderService {
    @Autowired
    JavaMailSender mailSender;
    @Override
    public Integer sendEmail(String email,String pass) {
        if(email==null){
            return 0;
        }else{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            try{
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setSubject("志愿报名注册验证码");
                helper.setFrom("15716273511@163.com");
                helper.setTo(email);
                helper.setSentDate(new Date());
                helper.setText("您的验证码为："+pass+"(五分钟内有效)");
            }catch (Exception e){
                return 0;
            }
            mailSender.send(mimeMessage);
            return 1;
        }
    }
}
