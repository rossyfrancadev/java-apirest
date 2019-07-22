package com.franca.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("barwebPU");

	public static EntityManager getConnection() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}

}
