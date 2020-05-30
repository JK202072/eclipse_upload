package com.hbsi.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	private static String DRIVER="";
	private static String URL="";
	private static String USERNAME="";
	private static String PASSWORD="";
	private  ConnectionFactory() { }
	static {
		getProperties();
	}
	private static void getProperties() {
		Thread curThread=Thread.currentThread();
		ClassLoader loader=curThread.getContextClassLoader();
		InputStream inStream=loader.getResourceAsStream("jdbc.properties");
		Properties prop=new Properties();
		try {
			prop.load(inStream);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DRIVER=prop.getProperty("driver");
		URL=prop.getProperty("url");
		USERNAME=prop.getProperty("username");
		PASSWORD=prop.getProperty("password");
	}
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(DRIVER);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

}
