package com.franca.services;

import com.franca.dao.UserDao;
import com.franca.models.LoginRequest;
import com.franca.models.Session;
import com.franca.models.User;

import io.jsonwebtoken.Claims;

public class UserService {

	public static boolean validActiveUser(User user) {
		boolean active = false;
		if (user.isAtivo() == true)
			active = true;

		return active;
	}

	public static Session authenticateUser(LoginRequest loginRequest) {
		User user = new User();
		Session session = new Session();
		user = UserDao.findByEmail(loginRequest.getEmail());
		if (user.getPassword().equals(loginRequest.getPassword())) {
			session.setAuthenticated(true);
			session.setUser(user.getEmail());
			session.setToken(AuthService.createJWT(session));
			Claims claim = AuthService.decodeJWT(session.getToken());
		}
		System.out.println(session);
		return session;
	}

}
