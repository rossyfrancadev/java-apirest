package com.franca.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.franca.models.User;

public class UserBusiness {

	public static boolean validActiveUser(User user) {
		boolean active = false;
		if (user.isAtivo() == true)
			active = true;

		return active;
	}

	public static void sendMailConfirmation(String email) {
		// Mail configurations
		String to = email;
		String from = "rossyfranca@gmail.com";
		String host = "localhost";
		String port = "3306";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");

		try {

			MimeMessage message = new MimeMessage(Session.getDefaultInstance(properties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("rossyfranca@gmail.com", "frajolinha666");
				}
			}));
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("subject");
			message.setText("Seu cadastro foi efetuado com sucesso!");

			Transport.send(message);
			System.out.println("Sent message successfully...");
		} catch (MessagingException e) {
			System.out.println("failed to sent email");
			e.printStackTrace();
		}
	}

}
