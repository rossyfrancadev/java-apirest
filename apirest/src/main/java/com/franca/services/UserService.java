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

import com.franca.dao.UserDao;
import com.franca.models.User;

public class UserService {

	public static boolean validActiveUser(User user) {
		boolean active = false;
		if (user.isAtivo() == true)
			active = true;

		return active;
	}

	public static boolean authenticateUser(String email, String password) {
		User user = new User();
		boolean ok = false;
		user = UserDao.findByEmail(email);
		if (user.getEmail() == email && user.getPassword() == password) {
			ok = true;
		}
		return true;
	}

}
