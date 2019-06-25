package com.signify.internshipproject.notificationservice.service;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import com.signify.internshipproject.notificationservice.model.Email;


public class EmailService {
	public boolean sendEmail(Email info) {
	
			final String username = "write2sindhumr@gmail.com";
			final String password = "kavya123";
			String toAddress=info.getEmailid();
			String msg=info.getMsg();

			// setting gmail smtp properties
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// check the authentication
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("write2sindhumr@gmail.com"));

				// recipients email address
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(info.getEmailid()));

				// add the Subject of email
				message.setSubject("JavaMail API Test");

				// message body
				message.setText(info.getMsg());// message
				System.out.println(info.getMsg());

				Transport.send(message);

			return true;

			} catch (MessagingException e) {
				
				throw new RuntimeException(e);

			}
		
		}
	}