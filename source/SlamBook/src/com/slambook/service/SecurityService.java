package com.slambook.service;

import com.slambook.model.UserProfile;

public interface SecurityService {
	UserProfile findLoggedInUser();

}
