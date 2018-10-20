package com.slambook.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.slambook.core.util.Localization;

public class ResetPasswordController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	final private Logger logger = Logger.getLogger(ForgetPasswordController.class);
	static{
		BasicConfigurator.configure();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("from ResetPasswordController get() :-");
		Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		req.setAttribute("bundle", Localization.getLocalizationContext());
		req.getRequestDispatcher("/WEB-INF/views/resetPassword.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("from ResetPasswordController post():- ");
		Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		if(!newPassword.equals(confirmPassword)){
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN007"));
			req.setAttribute("bundle", Localization.getLocalizationContext());
			req.getRequestDispatcher("/WEB-INF/views/resetPassword.jsp").forward(req, resp);
		}
		
	}
	

}
