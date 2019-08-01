package com.franca.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String UNIT_NAME = "testPU";
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public EntityManager getEntityManager() {
		if (null == emf)
			emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		if (null == em)
			em = emf.createEntityManager();

		return em;

	}

}
