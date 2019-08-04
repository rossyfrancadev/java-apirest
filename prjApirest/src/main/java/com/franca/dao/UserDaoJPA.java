package com.franca.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.franca.models.User;
import com.franca.utils.JPAUtil;

import jersey.repackaged.com.google.common.base.MoreObjects.ToStringHelper;

/**
 * E entidade Usuário terá somente a sua inclusão, alteração de senha e a
 * autenticação de usuário
 */
public class UserDaoJPA extends DAOJPA<User, Integer> implements UserDAO {

	// public static void save(User user) {
	// EntityManager entity = null;
	// try {
	// entity = JPAUtil.getConnection();
	// entity.getTransaction().begin();
	// Date data = new Date();
	// user.setDataCriacao(data);
	// user.setAtivo(true);
	// entity.persist(user);
	// entity.getTransaction().commit();
	// } catch (Exception e) {
	// System.out.println(e);
	// } finally {
	// entity.close();
	// }
	// }
	//
	// // TODO: Função com comportamento errado, pois o user não terá id
	// public static void updatePassword(User user) {
	// EntityManager entity = null;
	// try {
	// entity = JPAUtil.getConnection();
	// entity.getTransaction().begin();
	//
	// User foundUser = entity.find(User.class, user.getId());
	// if (foundUser != null) {
	// foundUser.setPassword(user.getPassword());
	// entity.merge(foundUser);
	// entity.getTransaction().commit();
	// } else {
	// System.out.println("user not found...");
	// }
	//
	// } catch (Exception e) {
	// System.out.println(e);
	// } finally {
	// entity.close();
	// }
	// }
	//
	
	
	public static User findByEmail(String email) {

		EntityManager manager = null;
		manager = JPAUtil.getEntityManager();
		CriteriaBuilder qb = manager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = qb.createQuery(User.class);

		Root<User> u = criteriaQuery.from(User.class);
		Predicate condition = qb.equal(u.get("email"), email);
		criteriaQuery.where(condition);
		TypedQuery<User> q = manager.createQuery(criteriaQuery);
		User result = q.getSingleResult();

		return result;

	}

}
