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

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Locale locale = null;
	public ResourceBundle bundle = null;
	public LocalizationContext localizationContext = null;
	final private Logger logger = Logger.getLogger(LoginController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicConfigurator.configure();
		logger.debug("from LoginController");
		String reqLaguage = request.getParameter("language");
		int language = 0;
		if (reqLaguage == null) {
			locale = new Locale(Locale.US.toString(), Locale.ENGLISH.toString());
		} else {
			language = Integer.parseInt(reqLaguage);
			if (language == (Constants.INDIA_ID)) {
				locale = new Locale(Locale.US.toString(), Locale.ENGLISH.toString());
				logger.debug("from if : ");

			} else if (language == Constants.JAPAN_ID) {
				logger.debug("from else if : ");
				locale = new Locale(Locale.JAPAN.toString(), Locale.JAPANESE.toString());
			}
		}
		Locale.setDefault(locale);
		logger.debug("locale : " + Locale.getDefault());
		bundle = ResourceBundle.getBundle("resources.messages", locale);

		request.setAttribute("englishName", bundle.getString("home.english"));
		request.setAttribute("japaneseName", bundle.getString("home.japanese"));
		localizationContext = new LocalizationContext(bundle, locale);
		request.setAttribute("bundle", localizationContext);
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
