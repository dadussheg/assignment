package com.slambook.core.util;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Velocity {
	public Template getTemplate(String template){
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate(template);
	}
	public String getData(VelocityContext context,Template t){
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		return writer.toString();
		
	}

}
