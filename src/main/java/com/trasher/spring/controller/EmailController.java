package com.trasher.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Email;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmailController {
	
	@PostMapping("/sendMail")
	private String sendmail(@RequestBody Email email) throws AddressException, MessagingException, IOException,NullPointerException {
	   System.out.println(email.getReciever());
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("trashercorporation@gmail.com", "Leavemealone_1");
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress("trashercorporation@gmail.com", false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getReciever()));
	   msg.setSubject(email.getSubject());
	   msg.setContent(email.getBody(), "text/html");
	   msg.setSentDate(new Date());

//	   MimeBodyPart messageBodyPart = new MimeBodyPart();
//	   messageBodyPart.setContent("Tutorials point email", "text/html");
//
//	   Multipart multipart = new MimeMultipart();
//	   multipart.addBodyPart(messageBodyPart);
//	   MimeBodyPart attachPart = new MimeBodyPart();
//
//	   attachPart.attachFile("/var/tmp/image19.png");
//	   multipart.addBodyPart(attachPart);
//	   msg.setContent(multipart);
	   Transport.send(msg);
	   return "Successfully sent!";
	}
    
}
