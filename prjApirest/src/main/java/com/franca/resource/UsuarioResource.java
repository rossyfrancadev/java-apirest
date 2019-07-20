package com.franca.resource;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.franca.dao.UserDao;
import com.franca.models.User;;

@Path("usuarios")
public class UsuarioResource {
	// GET expecifica o verbo da rota

	UserDao repo = new UserDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		System.out.println("get user called");

		return repo.getUsers();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id) {
		return repo.getUser(id);
	}

	@POST
	public User createUser(User user) {
		System.out.println(user);
		repo.create(user);
		return user;
	}
	
	
}
