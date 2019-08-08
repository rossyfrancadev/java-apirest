package com.franca.tests;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Teste {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void main(String[] args) throws AddressException, MessagingException, MessagingException {
		generateAndSendEmail();
	}

	public static void generateAndSendEmail() throws AddressException, MessagingException {

		// Step1
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		// Step2
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("abdullazin@gmail.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("rossyfrancadev@gmail.com"));
		generateMailMessage.setSubject("Assunto");
		String emailBody = "Teste de envio de email";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Email criado com sucesso");

		// Step 3
		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", "rossyfranca@gmail.com", "frajolinha666");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();

	}
}