package com.franca.services;

import com.franca.dao.UserDaoJPA;
import com.franca.models.LoginRequest;
import com.franca.models.Session;
import com.franca.models.User;


public class UserService {

	public static Session authenticateUser(LoginRequest loginRequest) {
		User user = new User();
		Session session = new Session();
		user = UserDaoJPA.findByEmail(loginRequest.getEmail());
		if (user.getPassword().equals(loginRequest.getPassword())) {
			session.setAuthenticated(true);
			session.setUser(user.getEmail());
			session.setId(user.getId());
			session.setToken(AuthService.createJWT(session));
		}
		return session;
	}

}
