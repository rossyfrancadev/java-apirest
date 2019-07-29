package com.franca.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") int id) {
		return ProductDao.getById(id);
	}

	/**
	 * TODO:Tratar retorno do recurso, verificar melhor forma de retorno
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertProduct(Product product) {
		ProductDao.save(product);
		return Response.status(201).build();
	}

	@PUT
	public Response modifyProduct(Product product) {
		ProductDao.update(product);
		return Response.status(200).entity(product).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@PathParam("id") int id) {
		ProductDao.removeById(id);
		return Response.ok()
				.status(202)
				.entity("Product id: " + id + " has removed successfully!")
				.build();
	}

}