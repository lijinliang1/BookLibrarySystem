package com.eleven.booklibrary.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
* 创建时间：2018年6月5日 下午3:13:59
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：EMail.java
* 类说明： 发送Email工具类
*/
public class Email {
	 private MailSender mailSender;
	 private SimpleMailMessage simpleMailMessage;

	  /**
	 * 方法名: sendMail 
	 * 参数名：@param subject  邮件主题
	 * 参数名：@param content 邮件主题内容
	 * 参数名：@param to      收件人Email地址
	 * 描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to) {
	
	    simpleMailMessage.setSubject(subject); //设置邮件主题
	    simpleMailMessage.setTo(to);             //设定收件人
	    simpleMailMessage.setText(content);  //设置邮件主题内容
	    mailSender.send(simpleMailMessage); //发送邮件
	}
	  //Spring 依赖注入
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
	    this.simpleMailMessage = simpleMailMessage;
	}
	  //Spring 依赖注入 
	public void setMailSender(MailSender mailSender) {
	    this.mailSender = mailSender;
	}
}
