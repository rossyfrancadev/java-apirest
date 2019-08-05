package com.franca.services;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.franca.dao.ClientDaoJPA;
import com.franca.models.Client;

public class ClientService {

	private static ClientDaoJPA dao = new ClientDaoJPA();

	public static Response getById(String token, int id) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == AuthService.verifyAuthorization(token))
				return Response.status(400).entity("Failed to authentication").build();
			Client client = dao.getById(Client.class, id);
			if (client == null)
				return Response.status(404).entity("Client id: " + id + " not found").build();

			return Response.ok().status(200).entity(client).build();

		}
	}

	@SuppressWarnings("unused")
	public static Response getAll(String token) {
		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == AuthService.verifyAuthorization(token))
				return Response.status(400).entity("Failed to authentication").build();
			List<Client> clients = dao.getAll(Client.class);
			GenericEntity<List<Client>> list = new GenericEntity<List<Client>>(clients) {
			};
			if (list == null)
				return Response.status(404).entity("Empty client list").build();

			return Response.ok().status(200).entity(list).build();
		}
	}

	public static Response save(Client client, String token) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == AuthService.verifyAuthorization(token))
				return Response.status(400).entity("Failed to authentication").build();

			Client saved = dao.save(client);
			return Response.status(201).entity(saved).build();
		}
	}

	public static Response delete(String token, int id) {

		if (null == token || token.isEmpty()) {
			return Response.status(401).entity("No token provided").build();
		} else {
			if (false == AuthService.verifyAuthorization(token))
				return Response.status(400).entity("Failed to authentication").build();

			boolean removed = dao.remove(Client.class, id);
			if (removed == false)
				return Response.ok().status(404).entity("Product was not removed").build();

			return Response.ok().status(200).entity("Product id: " + id + " has removed successfully!").build();
		}
	}
	

}
