package com.yd.atis.service.mail;

import com.yd.atis.facade.mail.MailFacade;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邮件发送服务
 * @author AsiQue
 * @since :2018.01.31 09:58
 */
@Component
public class MailFacadeImpl implements MailFacade {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;  //模板邮件配置

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${spring.mail.to}")
    private String mailTo;

    @Value("${spring.mail.cc}")
    private String mailCc;

    @Override
    public void sendSimpleEmail(String subject, String content) throws Exception{
        try {
            String[] toList = mailTo.split(",");
            String[] ccList = mailCc.split(",");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(toList);
            message.setCc(ccList);
            message.setSubject(subject);
            message.setText(content);

            mailSender.send(message);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void sendHtmlMail(String subject, String content) throws Exception{
        try {
            MimeMessage message = null;
            String[] toList = mailTo.split(",");
            String[] ccList = mailCc.split(",");

            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(toList);
            helper.setCc(ccList);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void sendAttachmentsMail(String subject, String content, String attachPath) throws Exception{
        try {
            MimeMessage message = null;
            String[] toList = mailTo.split(",");
            String[] ccList = mailCc.split(",");

            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(toList);
            helper.setCc(ccList);
            helper.setSubject(subject);
            helper.setText(content, true);
            //注意项目路径问题，自动补用项目路径
//            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
            File attachFile = new File(attachPath);
            //加入邮件
            helper.addAttachment(attachFile.getName(), attachFile);

            mailSender.send(message);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void sendInlineMail(String subject, String content) throws Exception{
        try {
            MimeMessage message = null;

            String[] toList = mailTo.split(",");
            String[] ccList = mailCc.split(",");

            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(toList);
            helper.setCc(ccList);
            helper.setSubject("主题：带静态资源的邮件");
            //第二个参数指定发送的是HTML格式,同时cid:是固定的写法
            helper.setText("<html><body>带静态资源的邮件内容 图片:<img src='cid:picture' /></body></html>", true);

            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
            helper.addInline("picture",file);

            mailSender.send(message);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void sendTemplateMail(String subject, String content) throws Exception{
        try {
            MimeMessage message = null;
            String[] toList = mailTo.split(",");

            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(toList);
            helper.setSubject("主题：模板邮件");

            Map<String, Object> model = new HashMap();
            model.put("username", "zggdczfr");

            //修改 application.properties 文件中的读取路径
//            FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//            configurer.setTemplateLoaderPath("classpath:templates");
            //读取 html 模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw e;
        }
    }
}
