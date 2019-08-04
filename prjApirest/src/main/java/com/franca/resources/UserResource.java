package com.franca.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.franca.dao.UserDaoJPA;
import com.franca.models.LoginRequest;
import com.franca.models.Session;
import com.franca.models.User;
import com.franca.services.UserService;

@Path("users")
public class UserResource {

	private UserDaoJPA dao = new UserDaoJPA();

	/*
	 * Recurso autenticação e recebimento de token
	 */
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginAuthentication(LoginRequest loginRequest) {
		System.out.println("successful login");
		Session userOk = UserService.authenticateUser(loginRequest);
		if (false != userOk.isAuthenticated()) {
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + userOk.getToken()).build();
		} else {
			return Response.status(401).build();
		}
	}

	/**
	 * Recurso para registrar novo usuário
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println(user);
		Date data = new Date();
		user.setDataCriacao(data);
		dao.save(user);
		return Response.status(201).build();
	}

	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout() {
		System.out.println("logout");
		return Response.status(200).build();

	}

}
