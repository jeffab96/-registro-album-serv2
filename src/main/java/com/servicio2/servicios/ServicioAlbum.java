package com.servicio2.servicios;

import java.util.List;

import com.servicio2.dto.Album;


public interface ServicioAlbum  {
	public List<Album> listar();
	Album buscarId(Integer idAlbum);
}
