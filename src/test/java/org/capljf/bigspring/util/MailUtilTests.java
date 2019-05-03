package org.capljf.bigspring.util;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.capljf.bigspring.BigspringApplicationTests;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jifang.liu created on 2019/5/3 13:33
 */
public class MailUtilTests extends BigspringApplicationTests {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private VelocityEngine velocityEngine;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1579461369@qq.com");
        message.setTo("1579461369@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        javaMailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("1579461369@qq.com");
        helper.setTo("1579461369@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\jifang.liu\\Pictures\\壁纸\\18000.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        javaMailSender.send(mimeMessage);

    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("1579461369@qq.com");
        helper.setTo("1579461369@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\jifang.liu\\Pictures\\壁纸\\18000.jpg"));
        helper.addInline("weixin", file);

        javaMailSender.send(mimeMessage);

    }

    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("1579461369@qq.com");
        helper.setTo("1579461369@qq.com");
        helper.setSubject("主题：模板邮件");

        VelocityContext context = new VelocityContext();
        context.put("username", "didi");
        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("/templates/template.vm", "UTF-8", context,stringWriter);
        helper.setText(stringWriter.toString(), true);

        javaMailSender.send(mimeMessage);
    }

}
