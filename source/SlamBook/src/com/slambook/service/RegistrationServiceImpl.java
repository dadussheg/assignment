package com.slambook.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.slambook.core.constants.Constants;
import com.slambook.core.util.Localization;
import com.slambook.core.util.Velocity;
import com.slambook.dao.ConnectionToDatabase;
import com.slambook.model.UserProfile;

/**
 * @author aditya
 *
 */
public class RegistrationServiceImpl implements RegistrationService {
  final private Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
  private ConnectionToDatabase connectionToDatabase = null;
  private ResultSet resultSet = null;
  private java.sql.PreparedStatement preparedStatement = null;
  private MailService mailService = null;
  private Velocity velocity = new Velocity();

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.slambook.service.RegistrationService#isAlreadyRegistered(com.slambook
   * .model.UserProfile)
   */
  @Override
  public boolean isAlreadyRegistered(UserProfile userProfile) {
    boolean result = Boolean.FALSE;
    connectionToDatabase = new ConnectionToDatabase();
    try {
      preparedStatement = connectionToDatabase.connection.prepareStatement("");
      preparedStatement.setString(1, "");
      resultSet = preparedStatement.executeQuery();
      if (resultSet != null)
        result = Boolean.TRUE;
      while (resultSet.next()) {

      }
    } catch (SQLException e) {
      result = Boolean.FALSE;
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

    return result;
  }

  @Override
  public void save(UserProfile userProfile) {
    int result = Constants.ZERO;
    connectionToDatabase = new ConnectionToDatabase();
    try {
      preparedStatement = connectionToDatabase.connection
          .prepareStatement("insert into user_profile(user_details_id,email,password) values(?,?,?);");
      preparedStatement.setString(1, "");
      preparedStatement.setString(2, "");
      preparedStatement.setString(3, "");
      result = preparedStatement.executeUpdate();

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

  }

  @Override
  public int isRegistered(Map<String, String> map) {
    int result = Constants.ZERO;
    ResultSet resultSet = null;
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    try {
      connectionToDatabase = new ConnectionToDatabase();
      preparedStatement = connectionToDatabase.connection.prepareStatement(
          "insert into user_details(first_name,surname,gender,created_datetime) values(?,?,?,now());");
      preparedStatement.setString(1, map.get("fname"));
      preparedStatement.setString(2, map.get("lname"));
      preparedStatement.setString(3, map.get("gender"));
      result = preparedStatement.executeUpdate();
      logger.debug("executeUpdate :- "+result);
      preparedStatement = connectionToDatabase.connection.prepareStatement("select user_details_id from user_details order by user_details_id desc limit 1");
      resultSet=preparedStatement.executeQuery();
      if(resultSet.next()){
        preparedStatement = connectionToDatabase.connection.prepareStatement("insert into user_profile(user_details_id,email,password) values(?,?,?)");
        preparedStatement.setString(1, resultSet.getString("user_details_id"));
        preparedStatement.setString(2, map.get("email"));
        preparedStatement.setString(3, bcrypt.encode(map.get("password")));
        result = preparedStatement.executeUpdate();
        logger.debug("execute update from user_profile :- "+result);
      }
      connectionToDatabase.connection.commit();
      mailService = new MailServiceImpl();
      String data = "";
      Template template = velocity.getTemplate("templates/registration.vm");
      VelocityContext context = new VelocityContext();
      context.put("title", "Sample");
      data = velocity.getData(context, template);
      logger.debug("data : -"+data);
      mailService.sendMail(Localization.getBundle().getString("MSGREG005"), data,map.get("email"));  
      result=Constants.ONE;
    } catch (SQLException e) {
      logger.error("Error :- " + e);
      result=Constants.ZERO;
      try {
        connectionToDatabase.connection.rollback();
      } catch (SQLException e1) {
        logger.debug("Error during rollback :- "+e1);
      }
    } finally {
      try {
        //resultSet.close();
        connectionToDatabase.connection.close();
        preparedStatement.close();
      } catch (SQLException e) {
        logger.debug("Error while closing database connection :- "+e);
      }

    }
    return result;
  }

}
