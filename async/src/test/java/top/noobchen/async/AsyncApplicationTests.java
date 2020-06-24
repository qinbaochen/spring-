package top.noobchen.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class AsyncApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;


    //测试发送一个简单的邮件
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("mail-1");
        mailMessage.setText("mail-1-context");
        mailMessage.setTo("1575117217@qq.com");
        mailMessage.setFrom("1575117217@qq.com");
        javaMailSender.send(mailMessage);
    }

    //测试发送一个复杂的邮件
    @Test
    void sendMimeEmail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("MimeEmail");
        helper.setText("<p style='color:blue'>MimeEmail</p>",true);
        helper.setTo("1575117217@qq.com");
        helper.setFrom("1575117217@qq.com");
        javaMailSender.send(mimeMessage);
    }


}
