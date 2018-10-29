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
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import com.slambook.core.util.Localization;
import com.slambook.core.util.Validator;
import com.slambook.core.util.Velocity;
import com.slambook.model.UserProfile;
import com.slambook.service.MailService;
import com.slambook.service.MailServiceImpl;
import com.slambook.service.UserProfileService;
import com.slambook.service.UserProfileServiceImpl;

public class ForgetPasswordController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MailService mailService = null;
	private Velocity velocity = new Velocity();
	private UserProfileService userProfileService = new UserProfileServiceImpl();
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
		UserProfile userProfile = userProfileService.findByEmail(email);
		logger.debug("from ForgetPasswordController post() :- ");
		logger.debug("email :- "+email);
		if(email.isEmpty()){
			req.setAttribute("error", Localization.getBundle().getString("registration.field.required"));
			
		}else if(!Validator.validate(email)){
			logger.debug("email validator :- "+Validator.validate(email));
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN003"));
		}else if(userProfile==null){
			logger.debug("email id not registered :- ");
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN009"));
		}else if(userProfile!=null && !email.equals(userProfile.getEmail())){
			logger.debug("email does not match :- ");
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN008"));
		}else{
			mailService = new MailServiceImpl();
			try{
			String data = "";
			Template template = velocity.getTemplate("templates/forget_password.vm");
			VelocityContext context = new VelocityContext();
			context.put("title", "Sample");
			data = velocity.getData(context, template);
			logger.debug("data : -"+data);
			mailService.sendMail(Localization.getBundle().getString("MSGLOGIN006"), data,email);	
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
