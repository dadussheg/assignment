package com.slambook.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

  @Override
  public UserProfile findByUserProfileId(Long userProfileId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserProfile> findAll() {
    // TODO Auto-generated method stub
    List<UserProfile> list = new ArrayList<UserProfile>();
    connectionToDatabase = new ConnectionToDatabase();
    try {
      preparedStatement = connectionToDatabase.connection.prepareStatement("select * from user_profile");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(resultSet.getString("email"));
        userProfile.setUsername(resultSet.getString("user_name"));
        userProfile.setPassword(resultSet.getString("password"));
        userProfile.setUserProfileId(Long.parseLong(resultSet.getString("user_profile_id")));
        list.add(userProfile);
      }

    } catch (SQLException e) {
      logger.error("Error :- " + e);
    } finally {
      try {
        resultSet.close();
        connectionToDatabase.connection.close();
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

    return list;
  }

  @Override
  public UserProfile findByEmail(String email) {
    UserProfile userProfile = null;
    connectionToDatabase = new ConnectionToDatabase();
    try {
      preparedStatement = connectionToDatabase.connection.prepareStatement("select * from user_profile where email=?");
      preparedStatement.setString(1, email);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        userProfile = new UserProfile();
        logger.debug("inside if:- ");
        userProfile.setEmail(resultSet.getString("email"));
        userProfile.setUsername(resultSet.getString("user_name"));
        userProfile.setUserProfileId(Long.parseLong(resultSet.getString("user_profile_id")));
        logger.debug("resultset :- " + resultSet.getString("email"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return userProfile;
  }

}
