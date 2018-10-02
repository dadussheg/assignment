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

import com.slambook.core.constants.Constants;
import com.slambook.core.util.Localization;
import com.slambook.core.util.SlambookListener;
import com.slambook.service.LoginService;
import com.slambook.service.LoginServiceImpl;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private Logger logger = Logger.getLogger(LoginController.class);
	private String value;
	private LoginService loginService=null;
	static {
		Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		//Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		//Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));

	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SlambookListener listener = SlambookListener.getInstance(getServletContext());
		BasicConfigurator.configure();
		System.out.println(("from LoginController"));
		logger.debug("value :-"+listener.getProperty("contextPath"));
		String reqLaguage = request.getParameter("language");
		int language = 0;
		if(reqLaguage!=null) {
			language = Integer.parseInt(reqLaguage);
			if (language == (Constants.INDIA_ID)) {
				Localization.setLocale(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
				//logger.debug("from if : ");
				System.out.println(("from if : "));
				//Localization.setDefaultLocale(Localization.getLocale());
			}if (language == Constants.JAPAN_ID) {
				//logger.debug("from else if : ");
				System.out.println(("from else if : "));
				Localization.setLocale(new Locale(Locale.JAPAN.toString(), Locale.JAPANESE.toString()));
			}
		}
		Localization.setDefaultLocale(Localization.getLocale());
		logger.debug("locale set to :- " + Localization.getDefaultLocale());
		//getServletContext().setInitParameter("bundle", ResourceBundle.getBundle("resources.messages", Localization.getLocale()).toString());
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		request.setAttribute("englishName", Localization.getBundle().getString("home.english"));
		request.setAttribute("japaneseName", Localization.getBundle().getString("home.japanese"));
		request.setAttribute("bundle", Localization.getLocalizationContext());
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		logger.debug("from LoginController post() :- ");
		Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
		Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
		logger.debug("username :- "+username+" "+"password :- "+password);
		loginService = new LoginServiceImpl();
		boolean result=loginService.login(username, password);
		req.setAttribute("bundle", Localization.getLocalizationContext());
		if(result){
			req.getSession().setAttribute("username", username);
		}else{
			req.setAttribute("error", Localization.getBundle().getString("MSGLOGIN002"));
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}
		

	}
	
	

}
