package com.franca.services;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.franca.dao.ProductDaoJPA;
import com.franca.models.Product;

public class ProductService {

	private static ProductDaoJPA dao = new ProductDaoJPA();

	public static Response getById(String token, int id) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == UserService.verifyAuthorisation(token))
				return Response.status(400).entity("Failed to authentication").build();

			Product product = dao.getById(Product.class, id);

			if (product == null)
				return Response.status(404).entity("product id " + id + " not found").build();

			return Response.ok().status(200).entity(product).build();
		}

	}

	@SuppressWarnings("unused")
	public static Response getAll(String token) {
		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == UserService.verifyAuthorisation(token))
				return Response.status(400).entity("Failed to authentication").build();
			// Devido a trabalhar com classes generics o java encontra um erro,
			// e por isso é necessário criar uma entidade generica
			List<Product> products = dao.getAll(Product.class);
			GenericEntity<List<Product>> list = new GenericEntity<List<Product>>(products) {
			};

			if (list == null)
				return Response.status(404).entity("Empty product list").build();

			return Response.ok().status(200).entity(list).build();
		}
	}

	public static Response save(Product product, String token) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == UserService.verifyAuthorisation(token))
				return Response.status(400).entity("Failed to authentication").build();

			Product saved = dao.save(product);
			return Response.status(201).entity(saved).build();
		}

	}

	public static Response delete(String token, int id) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == UserService.verifyAuthorisation(token))
				return Response.status(400).entity("Failed to authentication").build();

			boolean removed = dao.remove(Product.class, id);
			if (removed == false)
				return Response.ok().status(404).entity("Product was not removed").build();

			return Response.ok().status(200).entity("Product id: " + id + " has removed successfully!").build();
		}

	}

	public static Response modify(String token, Product product) {
		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == UserService.verifyAuthorisation(token))
				return Response.status(400).entity("Failed to authentication").build();

			Product saved = dao.save(product);
			return Response.status(200).entity(saved).build();
		}
	}
}
