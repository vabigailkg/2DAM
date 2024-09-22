
package db.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.pojos.Album;
import db.pojos.Group;
import utils.dbUtils.*;
import utils.functionalities.Sesion;

public class GroupManager implements GestorInterfaz<Group> {

	private Group group = new Group();

	public List<Group> getGroup() throws Exception {
		ArrayList<Group> ret = null;

		String sql = "select * from grupo";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Group>();

			Group grupo = new Group();

			Integer idGroup = resultSet.getInt("id");
			String imagen = resultSet.getString("imagen");
			String name = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			Date fecha = resultSet.getDate("fechaCreacion");
			Integer numReproduccion = resultSet.getInt("numReproduccion");

			grupo.setIdGroup(idGroup);
			grupo.setImagen(imagen);
			grupo.setName(name);
			grupo.setDescription(descripcion);
			grupo.setCreationDate(fecha);
			grupo.setNumReproduccion(numReproduccion);

			ret.add(grupo);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public List<Group> obtenerNombreDeGrupo(Album album, Group grupo) throws Exception {
		ArrayList<Group> ret = null;
		String sql = "select nombre from grupo where id='" + album.getIdGroup() + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Group>();
			grupo.setName(resultSet.getString("nombre"));

			ret.add(grupo);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public List<Sesion> getGroupForName(String nameGroup) throws Exception {
		ArrayList<Sesion> ret = null;
		String sql = "select * from grupo where nombre='" + nameGroup + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Sesion>();
			Sesion sesion = Sesion.getInstance();
			sesion.setIdAuthor(resultSet.getInt("id"));
			sesion.setImagen(resultSet.getString("imagen"));
			sesion.setName(resultSet.getString("nombre"));
			sesion.setDescription(resultSet.getString("descripcion"));
			sesion.setCreationDate(resultSet.getDate("fechaCreacion"));

			ret.add(sesion);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public Group getGroupInfo(String groupName) throws Exception {
		Group grupo = null;
		String sql = "SELECT * FROM grupo WHERE nombre = '" + groupName + "';";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			grupo = new Group();
			grupo.setName(resultSet.getString("nombre"));
			grupo.setImagen(resultSet.getString("imagen"));
			grupo.setCreationDate(resultSet.getDate("fechaCreacion"));
			grupo.setDescription(resultSet.getString("descripcion"));
			grupo.setNumReproduccion(resultSet.getInt("numReproduccion"));
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		return grupo;
	}

	@Override
	public List<Group> select(int id) throws Exception {
		ArrayList<Group> ret = null;
		String sql = "select * from grupo where id=" + id + ";";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Group>();

			Group grupo = new Group();

			Integer idGroup = resultSet.getInt("id");
			String imagen = resultSet.getString("imagen");
			String name = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			Date fecha = resultSet.getDate("fechaCreacion");
			Integer numReproduccion = resultSet.getInt("numReproduccion");

			grupo.setIdGroup(idGroup);
			grupo.setImagen(imagen);
			grupo.setName(name);
			grupo.setDescription(descripcion);
			grupo.setCreationDate(fecha);
			grupo.setNumReproduccion(numReproduccion);

			ret.add(grupo);
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
	public void insert(String nombre, String imagen, String descripcion, java.util.Date fecha) throws Exception {

		String sql = "insert into grupo(imagen, nombre , fechaCreacion , descripcion) values('" + imagen + "','"
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

	public void deleteName(String name) throws Exception {

		String sql = "delete from grupo where nombre='" + name + "';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Grupo eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun grupo con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	@Override
	public void update(String nombre, String imagen, String descripcion, java.util.Date fecha) throws Exception {

		String sql = "update grupo set imagen ='" + imagen + "',nombre='" + nombre + "',fechaCreacion='" + fecha
				+ "',descripcion='" + descripcion + "' where id=" + group.getIdAuthor() + ";";
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
			JOptionPane.showMessageDialog(null, "Grupo Actualizado");
		}
	}

	@Override
	public void delete(int id) throws Exception {

		String sql = "delete from grupo where id='" + id + "';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Grupo eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun grupo con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	public boolean checkIfGroupExists(String name) throws Exception {
		boolean ret = false;
		String sql = "select name from grupo where name='" + name + "'";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			ret = true;
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public boolean modifyGroupName(String name, String newName) throws Exception {
		boolean ret = false;
		String sql = "update grupo set name = '" + newName + "where name = '" + name + "';";

		try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, newName);
			statement.setString(2, name);

			int rowsAffected = statement.executeUpdate();
			ret = rowsAffected == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error modifying user password", e);
		}

		return ret;
	}

	public boolean deleteGroupByName(String name) throws Exception {
		boolean ret = false;
		String sql = "delete from grupo where name = '" + name + "';";

		try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, name);
			int rowsAffected = statement.executeUpdate();

			ret = rowsAffected == 1;
		}

		return ret;

	}

}
