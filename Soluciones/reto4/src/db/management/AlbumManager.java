package db.management;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import db.pojos.*;
import utils.dbUtils.*;

public class AlbumManager implements GestorInterfaz<Album> {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	Album album = new Album();

	public List<Album> obtenerGrupo() throws Exception {
		ArrayList<Album> ret = null;

		String sql = "select * from disco";

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Album>();

			Album disco = new Album();

			disco.setIdAlbum(resultSet.getInt("id"));
			disco.setIdGroup(resultSet.getInt("idGrupo"));
			disco.setCdImage(resultSet.getString("imagenDisco"));
			disco.setTitle(resultSet.getString("titulo"));
			disco.setDescription(resultSet.getString("descripcion"));
			disco.setPublicationDate(resultSet.getDate("fechaPublicacion"));
			disco.setGenre(resultSet.getString("genero"));

			ret.add(disco);

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

			;
		}
		return ret;
	}

	public int getMaxNumber() throws Exception {
		int ret = 0;
		String sql = "select count(*) from disco";

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			ret = resultSet.getInt(1);

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}

	public List<Album> getAlbum(Album album) throws Exception {
		ArrayList<Album> ret = null;
		String sql = "select * from disco where id='" + album.getIdAlbum() + "';";

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Album>();

			album.setIdAlbum(resultSet.getInt("id"));
			album.setIdGroup(resultSet.getInt("idGrupo"));
			album.setCdImage(resultSet.getString("imagenDisco"));
			album.setTitle(resultSet.getString("titulo"));
			album.setDescription(resultSet.getString("descripcion"));
			album.setPublicationDate(resultSet.getDate("fechaPublicacion"));
			album.setGenre(resultSet.getString("genero"));

			ret.add(album);
		}

		if (resultSet != null)
			resultSet.close();

		if (statement != null)
			statement.close();

		if (connection != null)
			connection.close();
		return ret;
	}

	public List<Album> getAlbumsByGroupId(int groupId) throws Exception {
		ArrayList<Album> ret = new ArrayList<>();
		String sql = "SELECT * FROM disco WHERE idGrupo = ?";

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, groupId);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Album album = new Album();
			album.setIdAlbum(resultSet.getInt("id"));
			album.setTitle(resultSet.getString("titulo"));
			ret.add(album);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public Album getGroupInfobyId(int albumId) throws Exception {
		String sql = "SELECT * FROM disco WHERE id = ?";
		Album album = new Album();
		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, albumId);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			album.setIdAlbum(resultSet.getInt("id"));
			album.setIdGroup(resultSet.getInt("idGrupo"));
			album.setCdImage(resultSet.getString("imagenDisco"));
			album.setTitle(resultSet.getString("titulo"));
			album.setDescription(resultSet.getString("descripcion"));
			album.setPublicationDate(resultSet.getDate("fechaPublicacion"));
			album.setGenre(resultSet.getString("genero"));
			album.setNumReproduccion(resultSet.getInt("numReproduccion"));
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return album;
	}

	@Override
	public List<Album> select(int id) throws Exception {
		ArrayList<Album> ret = null;

		String sql = "select * from podcaster where id=" + id + ";";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Album>();

			Album album = new Album();
			int idDisco = resultSet.getInt("id");
			Integer idGroup = resultSet.getInt("idGrupo");
			String imagen = resultSet.getString("imagenDisco");
			String name = resultSet.getString("titulo");
			String descripcion = resultSet.getString("descripcion");
			Date fecha = resultSet.getDate("fechaPublicacion");
			Integer numReproduccion = resultSet.getInt("numReproduccion");
			String genero = resultSet.getString("genero");

			album.setIdAlbum(idDisco);
			album.setIdGroup(idGroup);
			album.setCdImage(imagen);
			album.setTitle(name);
			album.setDescription(descripcion);
			album.setPublicationDate(fecha);
			album.setNumReproduccion(numReproduccion);
			album.setGenre(genero);

			ret.add(album);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();

		return ret;
	}

	@Override
	public void insert(String nombre, String imagen, String descripcion, Date fecha) throws Exception {

		String sql = "insert into grupo(imagenDisco, titulo , fechaPublicacion , descripcion) values('" + imagen + "','"
				+ nombre + "','" + fecha + "','" + descripcion + "');";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Grupo registrado con exito");
		}

	}

	@Override
	public void update(String nombre, String imagen, String descripcion, Date fecha) throws Exception {

		String sql = "update grupo set imagenDisco ='" + imagen + "',titulo='" + nombre + "',fechaPublicacion='" + fecha
				+ "',descripcion='" + descripcion + "' where id=" + album.getIdAlbum() + ";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Album Actualizado");
		}

	}

	@Override
	public void delete(int id) throws Exception {

		String sql = "delete from album where id='" + id + "';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Album eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun album con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	public void deleteById(int id) throws Exception {

		String sql = "delete from album where id='" + id + "';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Album eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun album con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

}