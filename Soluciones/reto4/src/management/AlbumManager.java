package management;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


import javax.swing.JOptionPane;

import pojos.Album;
import utils.DBUtils;

public class AlbumManager {
	public List<Album> obtenerGrupo(){
		ArrayList<Album> ret = null;

		String sql ="select * from disco";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Album>();

				Album disco = new Album();
				

				disco.setIdAlbum(resultSet.getInt("id"));
				disco.setIdGrupo(resultSet.getInt("idGrupo"));
				disco.setCdImage(resultSet.getString("imagenDisco"));
				disco.setTitle(resultSet.getString("titulo"));
				disco.setDescription(resultSet.getString("descripcion"));
				disco.setPublicationDate(resultSet.getDate("fechaPublicacion"));
				disco.setGenre(resultSet.getString("genero"));
				

				ret.add(disco);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
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
		return null;
	}
	/*
	public int getRandomNumber(){
		int ret =0;
		String sql ="select count(*) from disco";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				if (null == ret)
					ret=resulset;
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
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
		return int;
	}
	*/
	public List<Album> getRandomAlbum(){
		ArrayList<Album> ret = null;
		int idAleatorio = (int) (Math.floor(Math.random() * (1-7+1)+7));
		
		String sql ="select * from disco where id='"+idAleatorio+"';";
		

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Album>();

				Album disco = new Album();
				disco.setIdAlbum(resultSet.getInt("id"));
				disco.setIdGrupo(resultSet.getInt("idGrupo"));
				disco.setCdImage(resultSet.getString("imagenDisco"));
				disco.setTitle(resultSet.getString("titulo"));
				disco.setDescription(resultSet.getString("descripcion"));
				disco.setPublicationDate(resultSet.getDate("fechaPublicacion"));
				disco.setGenre(resultSet.getString("genero"));
				

				ret.add(disco);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
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
		return ret;
	}
	
	
	
}