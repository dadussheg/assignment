package com.slambook.service;

import java.util.List;

import com.slambook.model.UserProfile;

public interface UserProfileService {
	UserProfile findByUserProfileId(Long userProfileId);
	List<UserProfile> findAll();

}
