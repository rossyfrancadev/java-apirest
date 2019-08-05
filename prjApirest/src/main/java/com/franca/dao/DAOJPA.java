package com.franca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.franca.models.EntidadeBase;
import com.franca.utils.JPAUtil;

public abstract class DAOJPA<T extends EntidadeBase, I> implements DAO<T, I> {

	private JPAUtil connection;

	@Override
	public T save(T entity) {

		T saved = null;

		try {
			//If the entity has id == POST(persist), else PUT(merge) 
			if (Long.valueOf(entity.getId()) == null) {
				getEntityManager().persist(entity);
			} else {
				getEntityManager().getTransaction().begin();
				saved = getEntityManager().merge(entity);
			}

			getEntityManager().getTransaction().commit();

		} catch (Exception e) {

			if (getEntityManager().getTransaction().isActive() == false)
				getEntityManager().getTransaction().begin();

			getEntityManager().getTransaction().rollback();
			System.out.println("Error to insert element" + e.getMessage());

		}
		return saved;
	}

	@Override
	public boolean remove(Class<T> classe, I pk) {

		boolean state = false;

		try {

			getEntityManager().getTransaction().begin();
			getEntityManager().remove(getEntityManager().getReference(classe, pk));
			getEntityManager().getTransaction().commit();
			state = true;

		} catch (Exception e) {

			if (getEntityManager().getTransaction().isActive() == false)
				getEntityManager().getTransaction().begin();

			getEntityManager().getTransaction().rollback();
			System.out.println("Error to remove element: " + e.getMessage());

		}

		return state;
	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (Exception e) {
			System.out.println("id: " + pk + " not found");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {

		try {
			return getEntityManager().createQuery("select x from " + classe.getSimpleName() + " x").getResultList();
		} catch (Exception e) {
			System.out.println("get list error " + e.getMessage());
			return null;
		}

	}

	public T update(Class<T> classe, T entity) {
		T saved = null;
		try {
			T foundClass = getEntityManager().find(classe, entity);
			getEntityManager().getTransaction().begin();
			saved = getEntityManager().merge(foundClass);
			getEntityManager().getTransaction().commit();

		} catch (Exception e) {
			if (getEntityManager().getTransaction().isActive() == false)
				getEntityManager().getTransaction().begin();

			getEntityManager().getTransaction().rollback();
			System.out.println("Error to modify element" + e.getMessage());
		}
		return saved;
	}

	@Override
	public EntityManager getEntityManager() {
		if (null == connection)
			connection = new JPAUtil();
		return connection.getEntityManager();
	}
}
