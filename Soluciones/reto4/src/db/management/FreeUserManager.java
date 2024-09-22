package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import db.pojos.FreeUser;
import utils.dbUtils.DBUtils;

public class FreeUserManager {

	public void createFreeAccount(FreeUser freeUser) throws Exception {

		long regDate = freeUser.getRegisterDate().getTime();
		java.sql.Date registerDate = new java.sql.Date(regDate);

		long birthDate = freeUser.getBirthday().getTime();
		java.sql.Date birthdayDate = new java.sql.Date(birthDate);

		String sql = "INSERT INTO usuario (nombre, apellido1, apellido2, dni, fechaNacimiento, direccion, codPostal, ciudad, provincia, login, password1, tipoUsuario, fechaRegistro) VALUES ('"
				+ freeUser.getName() + "','" + freeUser.getFirstSurname() + "','" + freeUser.getSecondSurname() + "','"
				+ freeUser.getIdCard() + "','" + birthdayDate + "','" + freeUser.getAddress() + "','"
				+ freeUser.getPostalCode() + "','" + freeUser.getCity() + "','" + freeUser.getProvince() + "','"
				+ freeUser.getLogin() + "','" + freeUser.getPassword() + "','" + freeUser.getUserType() + "','"
				+ registerDate + "')";

		// Data truncated getUserType

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
		}
	}

	public int getIdUser(int id) throws Exception {
		int ret = 0;
		String sql = "select id from libre where id = '" + id + "';";
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
