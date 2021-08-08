package com.skilli.application.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.skilli.application.authentication.services.CustomUserDetailsService;
import com.skilli.application.authentication.utils.JwtUtils;

@Component
public class JwtAuthentication extends OncePerRequestFilter {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestTokenHeader = request.getHeader("Authorization");
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			try {
				String requestToken = requestTokenHeader.substring(7);
				String username = jwtUtils.extractUsername(requestToken);
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				userPassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);				
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		filterChain.doFilter(request, response);		
	}

}
