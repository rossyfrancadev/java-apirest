package com.franca.tests;

import com.franca.dao.UserDao;
import com.franca.services.UserService;

public class UserTests {

	public static void main(String[] args) {
		// Dao
		System.out.println(UserDao.findByEmail("teste"));
		// Service
		System.out.println(UserService.authenticateUser("teste", "teste"));
	}

}
