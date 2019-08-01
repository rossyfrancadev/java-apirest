package com.franca.services;

import com.franca.dao.UserDaoJPA;
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
		Claims claim = null;
		Session session = new Session();
		user = UserDaoJPA.findByEmail(loginRequest.getEmail());
		if (user.getPassword().equals(loginRequest.getPassword())) {
			session.setAuthenticated(true);
			session.setUser(user.getEmail());
			session.setToken(AuthService.createJWT(session));
			 claim = AuthService.decodeJWT(session.getToken());
		}
		System.out.println(session);
		System.out.println(claim);
		return session;
	}

}
