package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.pojos.Content;
import db.pojos.Song;
import utils.dbUtils.DBUtils;

public class ContentManager {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public List<Song> getContentByAlbunId(int idAlbum) throws Exception {
		ArrayList<Song> ret = new ArrayList<>();

		String sql = "SELECT * FROM contenido WHERE idCD = ?";

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, idAlbum);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			Content cancion = new Song();
			cancion.setIdContent(resultSet.getInt("id"));
			cancion.setTitle(resultSet.getString("titulo"));
			ret.add((Song) cancion);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public List<Content> getContentBySerieId(int idSerie) throws Exception {
		ArrayList<Content> ret = new ArrayList<>();

		String sql = "SELECT * FROM contenido WHERE idSerie = ?";

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, idSerie);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			Content podcast = new Song();
			podcast.setIdContent(resultSet.getInt("id"));
			podcast.setTitle(resultSet.getString("titulo"));
			ret.add((Song) podcast);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public Song getContentBySonId(int idContent) throws Exception {
		Song cancion = new Song();
		String sql = "SELECT * FROM contenido WHERE id = ?";

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, idContent);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			cancion.setTitle(resultSet.getString("titulo"));
			Time duration = resultSet.getTime("duracion");
			// Convertir el objeto Time a una cadena de texto en formato HH:mm:ss
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			String durationString = formatter.format(duration);
			cancion.setDuration(durationString);
			cancion.setPlayAmount(resultSet.getInt("numReproducciones"));
			cancion.setIdCd(resultSet.getInt("idCD"));
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return cancion;
	}

	public List<Song> getTop10() throws Exception {
		ArrayList<Song> ret = new ArrayList<>();

		String sql = "SELECT id, titulo , numReproducciones from contenido order by numReproducciones desc limit 10;";

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			Content cancion = new Song();
			cancion.setIdContent(resultSet.getInt("id"));
			cancion.setTitle(resultSet.getString("titulo"));
			cancion.setPlayAmount(resultSet.getInt("numReproducciones"));
			ret.add((Song) cancion);

		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

}
