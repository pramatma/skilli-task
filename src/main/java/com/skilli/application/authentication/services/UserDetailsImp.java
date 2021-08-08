package com.skilli.application.authentication.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.skilli.application.model.Users;

public class UserDetailsImp implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private Users user;

	public UserDetailsImp(Users user) {
		this.user = user;
	}

	public UserDetailsImp() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(user.getRole().equals("admin")) {
			return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
		}else {
			return Arrays.asList(new SimpleGrantedAuthority("USER"));
		}
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
