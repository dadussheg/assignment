package com.slambook.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.slambook.dao.ConnectionToDatabase;

public class LoginServiceImpl implements LoginService{
	private ConnectionToDatabase connectionToDatabase = null;
	private ResultSet resultSet = null;
	private java.sql.PreparedStatement preparedStatement = null;
	private Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Override
	public boolean login(String username, String password) {
		logger.debug("from login :- ");
		boolean result = false;
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		connectionToDatabase = new ConnectionToDatabase();
		try {
			preparedStatement = connectionToDatabase.connection.prepareStatement("select * from user_profile where user_name = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, encoder.encode(password));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				logger.debug("user profile id :- "+resultSet.getString("user_profile_id"));
				result = Boolean.TRUE;
			}
		} catch (SQLException e) {
			result = Boolean.FALSE;
			logger.error("Error :- "+e);
		} finally {
			try {
				resultSet.close();
				connectionToDatabase.connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Error :- "+e);
			}

		}
		
		return result;
	}

}
