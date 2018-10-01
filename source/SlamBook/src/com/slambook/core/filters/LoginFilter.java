package com.slambook.core.filters;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.slambook.controller.LoginController;
import com.slambook.core.util.Localization;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	final private Logger logger = Logger.getLogger(LoginFilter.class);
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		BasicConfigurator.configure();
		logger.debug("from LoginFilter :- ");
		HttpServletRequest req = (HttpServletRequest)request;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		logger.debug("locale :- "+Localization.getLocale());
		if(/*username.isEmpty() || password.isEmpty() ||*/ username==null || password==null){
			logger.debug("locale :- "+Localization.getLocale());
			Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
			Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
			request.setAttribute("bundle", Localization.getLocalizationContext());
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}else if(username.replaceAll("\\s", "").isEmpty() || password.replaceAll("\\s", "").isEmpty()){
			Localization.setBundle(ResourceBundle.getBundle("resources.messages", Localization.getLocale()));
			Localization.setLocalizationContext(new LocalizationContext(Localization.getBundle(), Localization.getLocale()));
			request.setAttribute("error", Localization.getBundle().getString("MSGLOGIN001"));
			request.setAttribute("bundle", Localization.getLocalizationContext());
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}
		else{
		// TODO Auto-generated method stub
		// place your code here
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
