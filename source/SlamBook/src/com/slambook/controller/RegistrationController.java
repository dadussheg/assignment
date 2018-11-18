package com.slambook.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.slambook.core.constants.Constants;
import com.slambook.core.util.Localization;
import com.slambook.model.User;
import com.slambook.model.UserProfile;
import com.slambook.service.MailServiceImpl;
import com.slambook.service.RegistrationService;
import com.slambook.service.RegistrationServiceImpl;
import com.slambook.service.UserProfileService;
import com.slambook.service.UserProfileServiceImpl;

/**
 * @author aditya
 *
 */
public class RegistrationController extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  final private Logger logger = Logger.getLogger(LoginController.class);
  private UserProfileService userProfile = new UserProfileServiceImpl();
  private RegistrationService registrationService = new RegistrationServiceImpl();

  /*
   * (non-Javadoc)
   * 
   * @see
   * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
   * javax.servlet.http.HttpServletResponse)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
    Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
    Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
    logger.debug("locale :- "+Localization.getLocale());
    try {
      request.setAttribute("bundle", Localization.getLocalizationContext());
      request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    } catch (ServletException e) {
      logger.error("Error :- " + e);
    } catch (IOException e) {
      logger.error("Error :- " + e);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
   * HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      logger.debug("from RegistrationController post() :- ");
      logger.debug("parameters :- " + request.getParameterMap());
      Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
      Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
      Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
      request.setAttribute("bundle", Localization.getLocalizationContext());
      String status = "";
      Map<String, String[]> map = request.getParameterMap();
      Map<String, String> map2 = new HashMap<String, String>();
      Set<Entry<String, String[]>> s = map.entrySet();
      Iterator<Entry<String, String[]>> it = s.iterator();
      logger.debug("fname :-" + map.get("fname"));
      while (it.hasNext()) {
        Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();
        String key = entry.getKey();
        String[] value = entry.getValue();
        map2.put(key, value[0]);
      }
      logger.debug("incoming fname :- " + map2.get("fname"));
      logger.debug("incoming lname :- " + map2.get("lname"));
      logger.debug("incoming gender :- " + map2.get("gender"));
      logger.debug("incoming email :- " + map2.get("email"));
      List<UserProfile> list = userProfile.findAll();
      for (UserProfile p : list) {
        if (p.getEmail().equals(map2.get("email"))) {
          status = Constants.STATUS_ERROR;
          break;

        }
      }
      if (status.equals(Constants.STATUS_ERROR)) {
        request.setAttribute("error", Localization.getBundle().getString("MSGREG001"));
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
      } else {
        int isRegistered = registrationService.isRegistered(map2);
        if (isRegistered == Constants.ONE) {
          request.setAttribute("success", Localization.getBundle().getString("MSGREG002"));
          request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } else {
          request.setAttribute("error", Localization.getBundle().getString("MSGREG002"));
          request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
        }
      }
    

  }
}
