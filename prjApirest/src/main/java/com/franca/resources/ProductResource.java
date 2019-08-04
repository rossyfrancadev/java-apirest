package com.franca.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.franca.dao.ProductDaoJPA;
import com.franca.models.Product;
import com.franca.services.ProductService;

@Path("products")
public class ProductResource {

	private ProductDaoJPA dao = new ProductDaoJPA();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@Context HttpHeaders httpHeader) {

		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ProductService.getAll(token);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@Context HttpHeaders httpHeader, @PathParam("id") int id) {

		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ProductService.getById(token, id);

	}

	/**
	 * TODO:Tratar retorno do recurso, verificar melhor forma de retorno
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertProduct(Product product, @Context HttpHeaders httpHeader) {

		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ProductService.save(product, token);

	}

	// TODO: Implementar método PUT corretamente utilizando generic e hibernate
	@PUT
	public Response modifyProduct(@Context HttpHeaders httpHeader, Product product) {

		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ProductService.modify(token, product);

	}

	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@Context HttpHeaders httpHeader, @PathParam("id") int id) {

		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ProductService.delete(token, id);

	}

}
