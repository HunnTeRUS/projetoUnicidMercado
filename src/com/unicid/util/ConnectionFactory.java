package com.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/BDMercado?useSSL=false";
			String login = "root";
			String senha = "yourviews";
			return (Connection) DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		
		try {
			
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
			if(conn != null) { conn.close(); }
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}
}