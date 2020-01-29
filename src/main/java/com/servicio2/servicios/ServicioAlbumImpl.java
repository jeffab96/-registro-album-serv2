package com.servicio2.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.servicio2.dto.Album;

@ApplicationScoped
public class ServicioAlbumImpl implements ServicioAlbum {
@Inject
private DataSource dataSource;
		
@Inject
private Album albu;

	public List<Album> listar() {

		
		String sql = "select * from album";

		List<Album> listAlbum = new ArrayList<Album>();
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(sql);
			ResultSet datos = sentencia.executeQuery();
			while (datos.next()) {
				albu = new Album();
				albu.setTitle(datos.getString(1));
				albu.setReleaseDate(datos.getDate(2));
				albu.setId(datos.getInt(3));
				albu.setIdSinger(datos.getInt(4));
				albu.setVersion(datos.getInt(5));
				listAlbum.add(albu);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listAlbum;

	}



	
	@Override
	public Album buscarId(Integer id) {
		Album album = new Album();
		String query = "SELECT * FROM album WHERE id= ?";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			while (resultado.next()) {
				album.setTitle(resultado.getString(1));
				album.setReleaseDate(resultado.getDate(2));
				album.setId(resultado.getInt(3));
				album.setIdSinger(resultado.getInt(4));
				album.setVersion(resultado.getInt(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

	


}
