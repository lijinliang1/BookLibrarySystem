package com.eleven.booklibrary.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eleven.booklibrary.util.Email;

/**
* 创建时间：2018年6月5日 下午3:15:32
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：EmailTest.java
* 类说明：
*/
public class EmailTest {
	 @Test
	 public void testSendMail() {
		ApplicationContext context = new ClassPathXmlApplicationContext("send-mail.xml");
        Email mail = (Email)context.getBean("simpleMail");
        mail.sendMail("开会事宜", "于2018年6月5日开会。", "1918528336@qq.com");
	 }
}
