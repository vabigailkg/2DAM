package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import db.pojos.Podcaster;
import utils.dbUtils.DBUtils;
import utils.functionalities.Sesion;

public class PodcasterManager implements GestorInterfaz<Podcaster> {
	private Podcaster podcaster = new Podcaster();

	public List<Podcaster> getPodcaster() throws Exception {
		ArrayList<Podcaster> ret = null;

		String sql = "select * from podcaster";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Podcaster>();

			Podcaster Podcaster = new Podcaster();

			Integer idPodcaster = resultSet.getInt("id");
			String name = resultSet.getString("nombre");

			Podcaster.setIdAuthor(idPodcaster);
			Podcaster.setName(name);

			ret.add(Podcaster);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public Podcaster getPodcasterInfo(int idPodcaster) throws Exception {
		Podcaster podcaster = null;
		String sql = "SELECT * FROM podcaster WHERE id = '" + idPodcaster + "';";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			podcaster = new Podcaster();
			podcaster.setName(resultSet.getString("nombre"));
			podcaster.setImagen(resultSet.getString("imagen"));
			podcaster.setCreationDate(resultSet.getDate("fechaCreacion"));
			podcaster.setDescription(resultSet.getString("descripcion"));
			podcaster.setNumReproduction(resultSet.getInt("numReproduccion"));
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
		return podcaster;
	}

	public List<Podcaster> getTop10Author() throws Exception {
		ArrayList<Podcaster> ret = null;

		String sql = "SELECT id , nombre ,descripcion , numReproduccion from grupo union SELECT id , nombre , descripcion, numReproduccion  from podcaster order by numReproduccion desc limit 10;";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Podcaster>();

			Podcaster author = new Podcaster();

			Integer idGroup = resultSet.getInt("id");
			String name = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			Integer numReproduccion = resultSet.getInt("numReproduccion");

			author.setIdAuthor(idGroup);
			author.setName(name);
			author.setDescription(descripcion);
			author.setNumReproduction(numReproduccion);

			ret.add(author);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public List<Sesion> getPodcastForName(String namePodcaster) throws Exception {
		ArrayList<Sesion> ret = null;
		String sql = "select * from podcaster where nombre='" + namePodcaster + "';";
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

	public void updatePodcaster(String nombre, String imagen, String descripcion, java.util.Date fecha)
			throws Exception {

		String sql = "update podcaster set imagen ='" + imagen + "',nombre='" + nombre + "',fechaCreacion='" + fecha
				+ "',descripcion='" + descripcion + "' where id=" + podcaster.getIdAuthor() + ";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Podcaster Modificado con Exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	public void deletePodcaster(String nombre) throws Exception {

		String sql = "delete from podcaster where nombre='" + nombre + "';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Podcaster eliminado con Exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	@Override
	public List<Podcaster> select(int id) throws Exception {
		ArrayList<Podcaster> ret = null;

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
				ret = new ArrayList<Podcaster>();

			Podcaster grupo = new Podcaster();

			Integer idGroup = resultSet.getInt("id");
			String imagen = resultSet.getString("imagen");
			String name = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			Date fecha = resultSet.getDate("fechaCreacion");
			Integer numReproduccion = resultSet.getInt("numReproduccion");

			grupo.setIdAuthor(idGroup);
			grupo.setImagen(imagen);
			grupo.setName(name);
			grupo.setDescription(descripcion);
			grupo.setCreationDate(fecha);
			grupo.setNumReproduction(numReproduccion);

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

		String sql = "insert into podcaster(imagen, nombre , fechaCreacion , descripcion) values('" + imagen + "','"
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
			JOptionPane.showMessageDialog(null, "Podcaster registrado con exito");
		}
	}

	@Override
	public void update(String nombre, String imagen, String descripcion, java.util.Date fecha) throws Exception {

		String sql = "update podcaster set imagen ='" + imagen + "',nombre='" + nombre + "',fechaCreacion='" + fecha
				+ "',descripcion='" + descripcion + "' where id=" + podcaster.getIdAuthor() + ";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		numeroFilas = statement.executeUpdate(sql);
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null, "Podcaster Modificado con Exito");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	@Override
	public void delete(int id) throws Exception {

		String sql = "delete from podcaster where id='" + id + "';";
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

	public void deleteName(String name) throws Exception {

		String sql = "delete from podcaster where nombre='" + name + "';";
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
}
