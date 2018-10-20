package com.slambook.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.slambook.controller.ForgetPasswordController;

public class MailServiceImpl implements MailService{
	final private Logger logger = Logger.getLogger(ForgetPasswordController.class);
	static{
		BasicConfigurator.configure();
	}
	@Override
	public void sendMail(String subject,String content,String to) {
		// TODO Auto-generated method stub
		String username = "ctwork258@gmail.com";
		String password = "captcha123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ashishdeodekar@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			//message.setSubject("sample");
			message.setSubject(subject);
			//message.setContent("<h1>Hello Dadushegaonkar</h1>","text/html;charset=utf-8");
			message.setContent(content,"text/html;charset=utf-8");
			Transport.send(message);
			logger.debug("mail sent to :- "+to);
		}catch(MessagingException e){
			e.printStackTrace();
			
		}
		
	}

}
