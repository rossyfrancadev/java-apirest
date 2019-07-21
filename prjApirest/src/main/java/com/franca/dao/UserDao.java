package com.franca.dao;

import javax.persistence.EntityManager;

import com.franca.models.User;
import com.franca.utils.ConnectionFactory;

/**
 * E entidade Usuário terá somente a sua inclusão, alteração de senha e a
 * autenticação de usuário
 */
public class UserDao {

	public static void save(User user) {
		EntityManager entity = null;
		try {
			entity = ConnectionFactory.getConnection();
			entity.getTransaction().begin();
			entity.persist(user);
			entity.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			entity.close();
		}
	}

	// TODO: Função com comportamento errado, pois o user não terá id
	public static void updatePassword(User user) {
		EntityManager entity = null;
		try {
			entity = ConnectionFactory.getConnection();
			entity.getTransaction().begin();

			User foundUser = entity.find(User.class, user.getId());
			if (foundUser != null) {
				foundUser.setPassword(user.getPassword());
				entity.merge(foundUser);
				entity.getTransaction().commit();
			} else {
				System.out.println("user not found...");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			entity.close();
		}
	}

	public static boolean authenticate(User user) {
		EntityManager entity = null;

		try {
			entity = ConnectionFactory.getConnection();
			entity.getTransaction().begin();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
}
