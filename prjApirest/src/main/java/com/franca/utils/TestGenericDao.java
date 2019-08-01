package com.franca.utils;

import java.util.Date;
import java.util.List;

import com.franca.dao.UserDaoJPA;
import com.franca.models.User;

public class TestGenericDao {

	public static void main(String[] args) {
		UserDaoJPA dao = new UserDaoJPA();
		User u = new User();
		u.setPassword("abc");
		u.setEmail("abc");
		u.setAtivo(true);
		Date data = new Date();
		u.setDataCriacao(data);
		dao.save(u);

		List<User> users = dao.getAll(User.class);
		for (User user : users) {
			System.out.println(user.getEmail());
		}
	}

}
