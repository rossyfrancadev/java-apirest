package com.franca.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.franca.models.User;

public class UserDao {
	List<User> users;

	public UserDao() {
		users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setEmail("rossyfranca@gmail.com");
		user.setPassword("123");
		user.setDataCriacao(new Date());

		User user2 = new User();
		user2.setId(2);
		user2.setEmail("rodrigofranca@gmail.com");
		user2.setPassword("123");
		user2.setDataCriacao(new Date());

		users.add(user);
		users.add(user2);
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUser(int id) {

		for (User a : users) {
			if (a.getId() == id)
				return a;
		}
		return null;
	}

	public void create(User user) {
		users.add(user);
	}
}
