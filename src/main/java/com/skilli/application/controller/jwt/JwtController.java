package com.skilli.application.controller.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilli.application.authentication.services.CustomUserDetailsService;
import com.skilli.application.authentication.utils.JwtUtils;
import com.skilli.application.model.jwtmodel.JwtRequest;
import com.skilli.application.model.jwtmodel.JwtResponse;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			System.out.println(" request body username :"+ jwtRequest.getUsername() +" password : "+jwtRequest.getPassword());
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		/** if authentication done then only below code will execute **/
		System.out.print(" user details username : "+ jwtRequest.getUsername());
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		System.out.print(" user details : "+ userDetails);
		String token = this.jwtUtils.generateToken(userDetails);
		System.out.println("JWT Token : "+ token);
		return ResponseEntity.ok(new JwtResponse(token));	
    }

}
