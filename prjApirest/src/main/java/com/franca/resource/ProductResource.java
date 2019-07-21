package com.franca.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.franca.dao.ProductDao;
import com.franca.models.Product;

@Path("products")
public class ProductResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		System.out.println("get products called");
		return ProductDao.findAll();
	}

}
