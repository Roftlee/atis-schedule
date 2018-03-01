package com.yd.atis.facade.mail;

/**
 * @author AsiQue
 * @since :2018.01.31 10:49
 */
public interface MailFacade {

    /**
     * 发送简单文本邮件
     */
    public void sendSimpleEmail(String subject, String content);

    /**
     * 发送Html邮件
     */
    public void sendHtmlMail(String subject, String content);

    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentsMail(String subject, String content, String attachPath);

    /**
     * 发送带静态资源的邮件
     */
    public void sendInlineMail(String subject, String content);

    /**
     * 发送模板邮件
     */
    public void sendTemplateMail(String subject, String content);
}
