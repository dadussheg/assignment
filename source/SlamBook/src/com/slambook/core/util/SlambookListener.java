package com.slambook.core.util;

import java.io.FileInputStream;
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
	private	InputStream inputStream = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		 try {
			 /*inputStream = new FileInputStream("resources/application.properties");
			 config.load(inputStream); */  
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
/*public class Config implements ServletContextListener {
    private static final String ATTRIBUTE_NAME = "config";
    private Properties config = new Properties();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new SomeRuntimeException("Loading config failed", e);
        }
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP.
    }

    public static Config getInstance(ServletContext context) {
        return (Config) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}*/