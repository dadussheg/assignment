
package com.slambook.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author aditya
 *
 */
public class ConnectionToDatabase {
	private String database = "";
	private String user = "";
	private String password = "";
	private String driverClass = "";
	private String url = "";
	private static Logger logger;
	public Connection connection = null;

	public ConnectionToDatabase() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src/resources/application.properties");
			properties.load(inputStream);
			database = properties.getProperty("jdbc.database");
			user = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			driverClass = properties.getProperty("jdbc.driver.class");
			url = properties.getProperty("jdbc.url");
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url + database, user, password);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public static void main(String[] args){
		new ConnectionToDatabase();
		System.out.println("successfull");
	}

}
