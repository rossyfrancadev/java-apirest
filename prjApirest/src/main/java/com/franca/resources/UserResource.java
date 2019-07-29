package com.franca.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.franca.dao.UserDao;
import com.franca.models.User;
import com.franca.services.UserService;

@Path("users")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginAuthentication() {
		System.out.println("efetuando login");
		String email = "teste";
		String password = "teste";
		boolean userOk = UserService.authenticateUser(email, password);

		return Response.ok().build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println(user);
		UserDao.save(user);
		return Response.status(201).build();
	}

}
