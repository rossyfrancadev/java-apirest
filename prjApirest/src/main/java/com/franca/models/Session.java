package com.franca.models;

import java.security.Principal;

public class Session implements Principal {

	private String user, token;
	private boolean authenticated = false;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Session() {

	}

	public Session(String user, String token) {
		this.user = user;
		this.token = token;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
