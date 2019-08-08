package com.franca.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.franca.models.User;
import com.franca.utils.JPAUtil;



/**
 * E entidade Usuário terá somente a sua inclusão, alteração de senha e a
 * autenticação de usuário
 */
public class UserDaoJPA extends DAOJPA<User, Integer> implements UserDAO {
	
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
