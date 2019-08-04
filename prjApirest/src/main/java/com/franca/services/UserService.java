package com.franca.services;

import javax.ws.rs.core.Response;

import com.franca.dao.UserDaoJPA;
import com.franca.models.LoginRequest;
import com.franca.models.Session;
import com.franca.models.User;

import io.jsonwebtoken.Claims;

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

	public static boolean verifyAuthorisation(String jwt) {
		boolean isOK = false;
		Claims claims = AuthService.decodeJWT(jwt);
		isOK = Boolean.parseBoolean((String) claims.get("sub")) == true ? true : false;
		return isOK;
	}

}
