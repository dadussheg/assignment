package com.slambook.core.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.jstl.fmt.LocalizationContext;

public class Localization {
	private static Locale locale;
	private static ResourceBundle bundle;
	private static LocalizationContext localizationContext;
	public static Locale getLocale() {
		return locale;
	}
	public static void setLocale(Locale locale) {
		Localization.locale = locale;
	}
	public static ResourceBundle getBundle() {
		return bundle;
	}
	public static void setBundle(ResourceBundle bundle) {
		Localization.bundle = bundle;
	}
	public static LocalizationContext getLocalizationContext() {
		return localizationContext;
	}
	public static void setLocalizationContext(LocalizationContext localizationContext) {
		Localization.localizationContext = localizationContext;
	}
	public static void setDefaultLocale(Locale locale){
		if(locale==null)
			Locale.setDefault(new Locale(Locale.US.toString(), Locale.ENGLISH.toString()));
		else
			Locale.setDefault(locale);
	}
	public static Locale getDefaultLocale(){
		return Locale.getDefault();
	}
}
