package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import db.pojos.PremiumUser;
import utils.dbUtils.DBUtils;

public class PremiumUserManager {

	public boolean createPremiumAccount(PremiumUser premiumUser) throws Exception {
		boolean ret = false;

		long regDate = premiumUser.getRegisterDate().getTime();
		java.sql.Date registerDate = new java.sql.Date(regDate);

		long birthDate = premiumUser.getBirthday().getTime();
		java.sql.Date birthdayDate = new java.sql.Date(birthDate);

		String sql = "INSERT INTO usuario (nombre, apellido1, apellido2, dni, fechaNacimiento, direccion, codPostal, ciudad, provincia, login, password1, tipoUsuario, fechaRegistro) VALUES ('"
				+ premiumUser.getName() + "','" + premiumUser.getFirstSurname() + "','" + premiumUser.getSecondSurname()
				+ "','" + premiumUser.getIdCard() + "','" + birthdayDate + "','" + premiumUser.getAddress() + "','"
				+ premiumUser.getPostalCode() + "','" + premiumUser.getCity() + "','" + premiumUser.getProvince()
				+ "','" + premiumUser.getLogin() + "','" + premiumUser.getPassword() + "','" + premiumUser.getUserType()
				+ "','" + registerDate + "')";

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
			JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
			ret = true;
		}
		return ret;
	}

	public String getIdByLogin(String login) throws Exception {
		String ret = null;
		String sql = "select id from usuario where login='" + login + "'";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getString("id");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}

	public boolean createPremiumAccountExtra(PremiumUser premiumUser, int id) throws Exception {
		boolean ret = false;
		String sql = "INSERT INTO premium (id, numTarjeta, caduca, cvv) VALUES ('" + id + "','"
				+ premiumUser.getCardNumber() + "','" + premiumUser.getExpirationDate() + "','" + premiumUser.getCvv()
				+ "')";

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
			JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
			ret = true;
		}
		return ret;
	}

	public int getIdUser(int id) throws Exception {
		int ret = 0;
		String sql = "select id from premium where id = '" + id + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getInt("id");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}
}
