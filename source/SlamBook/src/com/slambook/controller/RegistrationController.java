package com.slambook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.slambook.core.util.Localization;
import com.slambook.service.UserProfileService;
import com.slambook.service.UserProfileServiceImpl;

/**
 * @author aditya
 *
 */
public class RegistrationController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private Logger logger = Logger.getLogger(LoginController.class);
	private UserProfileService userProfile= new UserProfileServiceImpl();
	static{
		BasicConfigurator.configure();
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		logger.debug("from registration : "+Localization.getDefaultLocale());
		request.setAttribute("bundle", Localization.getLocalizationContext());
		try {
			request.getRequestDispatcher("/WEB-INF/views/home2.jsp").forward(request, response);
		} catch (ServletException e) {
			logger.error("Error :- "+e);
		} catch (IOException e) {
			logger.error("Error :- "+e);
		}
		logger.debug(getServletContext().getInitParameter("abc"));
		userProfile.findAll();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
