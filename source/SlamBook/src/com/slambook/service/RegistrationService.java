package com.slambook.service;

import com.slambook.model.UserProfile;

public interface RegistrationService {
	boolean isAlreadyRegistered(UserProfile userProfile);
	void save(UserProfile userProfile);
	

}
