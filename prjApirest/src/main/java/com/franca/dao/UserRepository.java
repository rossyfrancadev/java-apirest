package com.franca.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.franca.models.Usuario;

public class UserRepository {
	List<Usuario> users;

	public UserRepository() {
		users = new ArrayList<>();
		Usuario user = new Usuario();
		user.setId(1);
		user.setEmail("rossyfranca@gmail.com");
		user.setPassword("123");
		user.setDataCriacao(new Date());

		Usuario user2 = new Usuario();
		user2.setId(2);
		user2.setEmail("rodrigofranca@gmail.com");
		user2.setPassword("123");
		user2.setDataCriacao(new Date());

		users.add(user);
		users.add(user2);
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public Usuario getUser(int id) {

		for (Usuario a : users) {
			if (a.getId() == id)
				return a;
		}
		return null;
	}

	public void create(Usuario user) {
		users.add(user);
	}
}
