package com.skilli.application.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.skilli.application.model.Users;
import com.skilli.application.services.UserServices;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserServices userServices;

	@Override
	public UserDetails loadUserByUsername(String username){
		Users user = userServices.findByUsername(username);
		return new UserDetailsImp(user);
	}

}
