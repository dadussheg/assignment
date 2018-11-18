package com.slambook.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class SlambookListener implements ServletContextListener{
    private static final String ATTRIBUTE_NAME = "config";
	 private Properties config = new Properties();
	 private Logger logger = Logger.getLogger(SlambookListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.debug("from SlamBookListener contextInitialized():-");
		 try {
			 config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/resources/application.properties"));
	        } catch (IOException e) {
	            logger.error("Error :- "+e);
	        }
		 event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
	}
	 public String getProperty(String key) {
	        return config.getProperty(key);
	    }
	 public static SlambookListener getInstance(ServletContext context) {
	        return (SlambookListener) context.getAttribute(ATTRIBUTE_NAME);
	    }

}