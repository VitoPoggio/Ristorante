package com.ristorante.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess implements Constants {

	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Driver);
		conn = DriverManager.getConnection(URL, username, password);
		conn.setAutoCommit(false);

		return conn;
	}

	public static void closeConnection() throws SQLException {
		if (conn != null)
			conn.close();
	}
}
