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
import com.franca.dao.ProductDaoJPA;
import com.franca.models.Product;

@Path("products")
public class ProductResource {

	private ProductDaoJPA dao = new ProductDaoJPA();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		System.out.println("get products called");
		return dao.getAll(Product.class);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") int id) {
		return dao.getById(Product.class, id);
	}

	/**
	 * TODO:Tratar retorno do recurso, verificar melhor forma de retorno
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertProduct(Product product) {
		Product saved = dao.save(product);
		return Response.status(201).entity(saved).build();
	}
	// TODO: Implementar método PUT corretamente utilizando generic e hibernate
	// @PUT
	// public Response modifyProduct(Product product) {
	// ProductDaoJPA.update(product);
	// return Response.status(200).entity(product).build();
	// }

	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@PathParam("id") int id) {
		boolean removed = dao.remove(Product.class, id);
		if (removed != false) {
			return Response.ok().status(200).entity("Product id: " + id + " has removed successfully!").build();
		}
		return Response.ok().entity("Product was not removed").build();
	}

}
