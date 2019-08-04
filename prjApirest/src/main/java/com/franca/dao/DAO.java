package com.franca.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<T, I> {

	T save(T entity);
	
	boolean remove(Class<T> clsse, I pk);
	
	T getById(Class<T> classe, I pk);
	
	List<T> getAll(Class<T> classe);
	
	EntityManager getEntityManager();

	
}
