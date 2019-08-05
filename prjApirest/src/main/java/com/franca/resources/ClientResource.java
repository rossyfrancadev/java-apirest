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
import com.franca.models.Client;
import com.franca.services.ClientService;

@Path("clients")
public class ClientResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClients(@Context HttpHeaders httpHeader) {
		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ClientService.getAll(token);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientById(@Context HttpHeaders httpHeader, @PathParam("id") int id) {
		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ClientService.getById(token, id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertClient(Client client, @Context HttpHeaders httpHeader) {
		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ClientService.save(client, token);
	}

	@DELETE
	@Path("/{id}")
	public Response deleteClient(@Context HttpHeaders httpHeader, @PathParam("id") int id) {
		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ClientService.delete(token, id);
	}

	@PUT
	public Response modifyClient(@Context HttpHeaders httpHeader, Client client) {
		String token = null;
		token = httpHeader.getHeaderString("Authorization");
		return ClientService.save(client, token);
	}
}
