package com.slambook.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
@WebServlet(value = "/login")
public class LoginController extends HttpServlet {
	final private Logger logger = Logger.getLogger(LoginController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.debug("from /login");
		Locale locale = new Locale(Locale.US.toString(),Locale.ENGLISH.toString());
		Locale.setDefault(locale);
		ResourceBundle bundle = ResourceBundle.getBundle("resources.messages",locale);
		req.setAttribute("englishName", bundle.getString("home.english"));
		req.setAttribute("japaneseName", bundle.getString("home.japanese"));
		req.getRequestDispatcher("/WEB-INF/views/sample.jsp").forward(req, resp);
		
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
/*<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> --%>*/