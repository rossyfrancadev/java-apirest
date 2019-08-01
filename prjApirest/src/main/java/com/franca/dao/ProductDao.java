package com.franca.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.franca.models.Product;
import com.franca.utils.JPAUtil;

public class ProductDao {

	// @SuppressWarnings("unchecked")
	// public static List<Product> findAll() {
//		List<Product> products = new ArrayList<>();
//		EntityManager entity = null;
//		try {
//			entity = JPAUtil.getConnection();
//			entity.getTransaction().begin();
//			products = entity.createQuery("FROM " + Product.class.getName()).getResultList();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity.getTransaction().rollback();
//		} finally {
//			entity.close();
//		}
//		return products;
//	}
//
//	public static void save(Product product) {
//		EntityManager entity = null;
//		try {
//			entity = JPAUtil.getConnection();
//			entity.getTransaction().begin();
//			entity.persist(product);
//			entity.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity.getTransaction().rollback();
//		} finally {
//			entity.close();
//		}
//	}
//
//	public static void update(Product product) {
//		EntityManager entity = JPAUtil.getConnection();
//		try {
//			entity.getTransaction().begin();
//			Product foundProduct = entity.find(Product.class, product.getId());
//			foundProduct.setNome(product.getNome());
//			foundProduct.setDescricao(product.getDescricao());
//			foundProduct.setPrecoVenda(product.getPrecoVenda());
//			foundProduct.setQuantidade(product.getQuantidade());
//			entity.merge(foundProduct);
//			entity.getTransaction().commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity.getTransaction().rollback();
//		} finally {
//			entity.close();
//		}
//	}
//
//	public static void removeById(final int id) {
//		EntityManager entity = JPAUtil.getConnection();
//		try {
//			entity.getTransaction().begin();
//			Product product = entity.find(Product.class, id);
//			entity.remove(product);
//			entity.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity.getTransaction().rollback();
//		} finally {
//			entity.close();
//		}
//	}
//
//	public static Product getById(final int id) {
//		EntityManager entity = JPAUtil.getConnection();
//		Product product = null;
//		try {
//			entity.getTransaction().begin();
//			product = entity.find(Product.class, id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity.getTransaction().rollback();
//		}
//		return product;
//	}

}
