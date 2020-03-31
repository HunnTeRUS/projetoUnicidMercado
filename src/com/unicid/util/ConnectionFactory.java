package com.unicid.util;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/BDMercado";
			String login = "root";
			String senha = "";
			return (Connection) DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(Connection conn, Statement smt, ResultSet rs) {
		try {
			if (!rs.equals(null))
				rs.close();

			if (!smt.equals(null))
				smt.close();

			if (!conn.equals(null))
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection conn, Statement smt, ResultSet rs) throws Exception {
		close(conn, smt, rs);
	}

	public static void closeConnection(Connection conn, Statement smt) throws Exception {
		close(conn, smt, null);
	}

	public static void closeConnection(Connection conn, ResultSet rs) throws Exception {
		close(conn, null, rs);
	}
}
