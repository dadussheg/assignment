package com.slambook.core.util;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.slambook.controller.LoginController;

public class JacksonUtil {
	final private static Logger logger = Logger.getLogger(LoginController.class);
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		BasicConfigurator.configure();
	}

	public static <T> Object convertJsonToJava(String json, Class<T> cls) {

		Object result = null;
		try {

			result = mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			logger.debug("JSON to JAVA parsing error " + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.debug("JSON to JAVA mapping error " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("JSON to JAVA IO error " + e.getMessage());
			e.printStackTrace();
		}
		return result;

	}

	public static String convertJavaToJson(Object object) {
		String jsonResult = "";
		try {
			jsonResult = mapper.writeValueAsString(object);
		} catch (JsonParseException e) {
			logger.debug("JSON to JAVA parsing error " + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.debug("JSON to JAVA mapping error " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("JSON to JAVA IO error " + e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;

	}

}
