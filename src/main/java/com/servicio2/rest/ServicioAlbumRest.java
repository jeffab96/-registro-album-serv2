package com.servicio2.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.servicio2.dto.Album;
import com.servicio2.servicios.ServicioAlbum;

@Path("/albums")
@ApplicationScoped
public class ServicioAlbumRest implements Serializable {


	private static final long serialVersionUID = 1L;
@Inject
	private ServicioAlbum servicio;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Album> listar() {
		return servicio.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Album buscarId(@PathParam("id") Integer id) {
		System.out.println("asdasdd");
		return servicio.buscarId(id);
	}
}
