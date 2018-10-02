package com.slambook.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.slambook.controller.LoginController;
import com.slambook.dao.ConnectionToDatabase;
import com.slambook.model.UserProfile;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UserProfileServiceImpl implements UserProfileService {
	private ConnectionToDatabase connectionToDatabase = null;
	private ResultSet resultSet = null;
	private java.sql.PreparedStatement preparedStatement = null;
	final private Logger logger = Logger.getLogger(LoginController.class);
	static{
		BasicConfigurator.configure();
	}

	@Override
	public UserProfile findByUserProfileId(Long userProfileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		connectionToDatabase = new ConnectionToDatabase();
		try {
			preparedStatement = connectionToDatabase.connection.prepareStatement("select * from user_profile");
			resultSet = preparedStatement.executeQuery();
			logger.debug("result set : "+resultSet);
			while (resultSet.next()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				connectionToDatabase.connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}