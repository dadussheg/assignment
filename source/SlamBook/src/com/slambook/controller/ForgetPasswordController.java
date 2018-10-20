package com.slambook.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.catalina.startup.VersionLoggerListener;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.slambook.core.util.Localization;
import com.slambook.core.util.Validator;
import com.slambook.service.MailService;
import com.slambook.service.MailServiceImpl;

public class ForgetPasswordController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MailService mailService = null;
	final private Logger logger = Logger.getLogger(ForgetPasswordController.class);
	static{
		BasicConfigurator.configure();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("from ForgetPasswordController get() :- ");
		
		Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		req.setAttribute("bundle", Localization.getLocalizationContext());
		req.getRequestDispatcher("/WEB-INF/views/forgetPassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		String email = req.getParameter("email");
		
		logger.debug("from ForgetPasswordController post() :- ");
		logger.debug("email :- "+email);
		if(email.isEmpty()){
			req.setAttribute("error", Localization.getBundle().getString("registration.field.required"));
			
		}else if(!Validator.validate(email)){
			logger.debug("email validator :- "+Validator.validate(email));
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN003"));
		}else{
			mailService = new MailServiceImpl();
			try{
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();
			Template template = ve.getTemplate("templates/forget_password.vm");
			VelocityContext context = new VelocityContext();
			context.put("title", "Sample");
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			logger.debug(writer.toString());
			mailService.sendMail(Localization.getBundle().getString("MSGLOGIN006"), writer.toString(),email);	
			req.setAttribute("error",Localization.getBundle().getString("MSGLOGIN005"));
			}catch(Exception ex){
				logger.error("Error :- "+ex);
				req.setAttribute("error",Localization.getBundle().getString("MSGLOGIN004"));
			}
		}	
		req.setAttribute("bundle", Localization.getLocalizationContext());
		req.getRequestDispatcher("/WEB-INF/views/forgetPassword.jsp").forward(req, resp);
		
	}
	
	

}
