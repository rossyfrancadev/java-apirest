package com.franca.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.franca.dao.UserDao;
import com.franca.models.User;;

@Path("usuarios")
public class UserResource {
	// GET expecifica o verbo da rota

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		System.out.println("get user called");

		return null;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id) {
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println(user);
		UserDao.save(user);
		return Response.status(201).build();
	}

}
