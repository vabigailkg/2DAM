package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utils.dbUtils.DBUtils;
import utils.functionalities.Sesion;

public class SongManager {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Sesion sesion = Sesion.getInstance();

	public List<String> getSongNames() throws Exception {
		List<String> songNames = new ArrayList<>();

		String sql = "SELECT titulo FROM contenido WHERE idCD = ?";

		try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, sesion.getIdAlbum());
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String songName = resultSet.getString("titulo");
					songNames.add(songName);
				}
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		}
		return songNames;
	}

	public List<String> getPodcastNames() throws Exception {
		List<String> songNames = new ArrayList<>();

		String sql = "SELECT titulo FROM contenido WHERE idCD = ?";

		try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, sesion.getIdSeries());
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String songName = resultSet.getString("titulo");
					songNames.add(songName);
				}
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		}
		return songNames;
	}

	public boolean updateNumReproduction(String nombre) throws Exception {
		String sql = "update Contenido set numReproducciones=numReproducciones + 1 where titulo=" + nombre + ";";

		Connection connection = null;

		Statement statement = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		statement.executeUpdate(sql);

		if (statement != null)
			statement.close();

		if (connection != null)
			connection.close();
		return false;
	}

	public boolean updateNumReproduction1(String nombre) throws Exception {
		String sql = "update contenido set numReproducciones=numReproducciones + 1 where titulo='" + nombre + "';";

		boolean ret = false;

		try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, nombre);

			int rowsAffected = statement.executeUpdate();
			ret = rowsAffected == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error update numReproduction", e);
		}
		return ret;
	}

	public int delete(int id) throws Exception {
		String sql = "delete from contenido where id=" + id + ";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return numeroFilas;
	}
}
