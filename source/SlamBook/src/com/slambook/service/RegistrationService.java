package com.slambook.service;

import java.util.Map;

import com.slambook.model.UserProfile;

/**
 * @author aditya
 *
 */
public interface RegistrationService {
	/**
	 * @param userProfile
	 * @return
	 */
	boolean isAlreadyRegistered(UserProfile userProfile);
	/**
	 * @param userProfile
	 */
	void save(UserProfile userProfile);
	/**
	 * @param map
	 * @return
	 */
	int isRegistered(Map<String,String> map);
	

}
