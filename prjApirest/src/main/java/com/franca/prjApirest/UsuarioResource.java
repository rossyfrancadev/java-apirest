package com.franca.prjApirest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.franca.dao.UserRepository;
import com.franca.models.Usuario;;

@Path("usuarios")
public class UsuarioResource {
	// GET expecifica o verbo da rota

	UserRepository repo = new UserRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsers() {
		System.out.println("get user called");

		return repo.getUsers();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUser(@PathParam("id") int id) {
		return repo.getUser(id);
	}

	@POST
	public Usuario createUser(Usuario user) {
		System.out.println(user);
		repo.create(user);
		return user;
	}
	
	
}
