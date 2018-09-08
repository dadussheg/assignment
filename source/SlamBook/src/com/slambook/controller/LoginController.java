package com.slambook.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.VersionLoggerListener;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import com.slambook.constants.Constants;
import com.slambook.core.util.JacksonUtil;
import com.slambook.model.User;
@WebServlet(value = "/login")
public class LoginController extends HttpServlet {
	final private Logger logger = Logger.getLogger(LoginController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.debug("from /login");
		String language = req.getParameter("language");
		Locale locale = null;
		if(language.equals(Constants.JAPANESE)){
			locale = new Locale(Locale.JAPAN.toString(),Locale.JAPANESE.toString());
		}else
			locale = new Locale(Locale.US.toString(),Locale.ENGLISH.toString());
		Locale.setDefault(locale);
		ResourceBundle bundle = ResourceBundle.getBundle("resources.messages",locale);
		req.setAttribute("englishName", bundle.getString("home.english"));
		req.setAttribute("japaneseName", bundle.getString("home.japanese"));
		req.getRequestDispatcher("/WEB-INF/views/sample.jsp").forward(req, resp);
		
		/*  first, get and initialize an engine  */
        
		VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template t = null;
        String data="";
        String jsonString ="{\"firstName\":\"aditya\",\"middleName\":\"arun\",\"surName\":\"shegaonkar\"}";
        User user=(User) JacksonUtil.convertJsonToJava(jsonString, User.class);
        logger.debug("user : "+user.getFirstName());
        /*  next, get the Template  */
        try{
         t= ve.getTemplate( "/src/templates/sample.vt" );
        }catch(ResourceNotFoundException exception){
        	logger.error("Error "+exception);
        }
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "world");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}