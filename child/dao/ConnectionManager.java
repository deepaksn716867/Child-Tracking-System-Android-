package com.child.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	static Connection conn = null;
	//static String url = "jdbc:mysql://localhost:3306/cps"; instance38152.db.xeround.com//instance25735.db.xeround.com:16871/childtrack
	static String url = "jdbc:mysql://instance39704.db.xeround.com:7477/cps";
/**
 * Credentials of Database.
 * @return
 */
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

//			String username = "root"; 
//			String password = "root"; 
			String username = "admin";
			String password = "admin"; 

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
