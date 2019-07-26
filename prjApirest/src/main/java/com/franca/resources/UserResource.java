package com.franca.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.franca.dao.UserDao;
import com.franca.models.User;
import com.franca.services.UserService;;

@Path("usuarios")
public class UserResource {
	// GET expecifica o verbo da rota

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginAuthentication(String email, String password) {
		System.out.println("efetuando login");
		email = "teste";
		password = "teste";
		boolean userOk = UserService.authenticateUser(email, password);

		return Response.ok().entity(userOk).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println(user);
		UserDao.save(user);
		return Response.status(201).build();
	}

}
