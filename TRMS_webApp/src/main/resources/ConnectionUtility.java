package com.Revature.TRMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	private static final String CONNECTION_USERNAME = "trmsDemo";
	private static final String CONNECTION_PASSWORD = "some_p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	/*
		private static final String URL = "jdbc:oracle:thin:@//host:port/service";
		host: the hostname of the machine running Oracle
		port: the port that Oracle is listening for connections on
		service: the database instance to connect to
	*/
	
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
}
