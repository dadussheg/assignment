
package com.slambook.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.slambook.core.util.SlambookListener;

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
	SlambookListener listener;
	/**
	 * 
	 */
	public ConnectionToDatabase() {		
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/resources/application.properties"));
			database = properties.getProperty("jdbc.database");
			user = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			driverClass = properties.getProperty("jdbc.driver.class");
			url = properties.getProperty("jdbc.url");
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url + database, user, password);
		} catch (FileNotFoundException e1) {
			logger.error("Error :-"+e1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
