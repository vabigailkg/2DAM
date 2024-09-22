package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.pojos.Series;
import utils.dbUtils.DBUtils;

public class SeriesManager {
	private Series serie = new Series();

	public List<Series> getSeries(int idPodcaster) throws Exception {
		ArrayList<Series> ret = null;

		String sql = "SELECT * FROM serie WHERE idPodcaster = '" + idPodcaster + "';";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			if (null == ret)
				ret = new ArrayList<Series>();

			Series serie = new Series();

			Integer idSerie = resultSet.getInt("id");
			String name = resultSet.getString("titulo");

			serie.setIdSeries(idSerie);
			serie.setTitle(name);

			ret.add(serie);
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public Series getSeriesInfo(int idSeries) throws Exception {
		Series serie = null;
		String sql = "SELECT * FROM serie WHERE id = '" + idSeries + "';";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			serie = new Series();
			serie.setTitle(resultSet.getString("titulo"));
			serie.setTopic(resultSet.getString("tematica"));
			serie.setStartDate(resultSet.getDate("fechaInicio"));
			serie.setEndDate(resultSet.getDate("fechaFin"));
			serie.setNumReproduction(resultSet.getInt("NumReproduccion"));
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
		return serie;
	}

	public List<Series> getTop10() throws Exception {
		ArrayList<Series> ret = new ArrayList<>();

		String sql = "SELECT id , titulo ,descripcion , numReproduccion from disco union SELECT id , titulo , descripcion, numReproduccion  from serie order by numReproduccion desc limit 10;";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			Series disco = new Series();
			disco.setIdSeries(resultSet.getInt("id"));
			disco.setTitle(resultSet.getString("titulo"));
			disco.setDescription(resultSet.getString("descripcion"));
			disco.setNumReproduction(resultSet.getInt("numReproduccion"));
			ret.add((Series) disco);
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
