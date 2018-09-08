package com.slambook.service;

import java.util.List;

import com.slambook.model.UserDetails;

public interface UserDetailsService {
	List<UserDetails> findAll();
	UserDetails findByUserDetailId(Long userDetailId);

}
