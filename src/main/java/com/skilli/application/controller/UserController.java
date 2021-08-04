package com.skilli.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilli.application.exceptions.ResourceNotFoundException;
import com.skilli.application.model.Users;
import com.skilli.application.services.UserServices;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userServices.getUserList());
    }
	
	@GetMapping("/user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
		Users user = null;
        try {
        	user = this.userServices.findUserById(id);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.ok().body(user);
    }
	
	@PostMapping("/register")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(this.userServices.createUser(user));
    }
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable(value = "id") int userId, @RequestBody Users userDetais){
		
		Users upadatedUser = null;
		try {
			Users user = this.userServices.findUserById(userId);
			user.setName(userDetais.getName());
			user.setUsername(userDetais.getUsername());
			user.setPassword(passwordEncoder.encode(userDetais.getPassword()));
			upadatedUser = this.userServices.createUser(user);	
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(upadatedUser);
	}
	
	@DeleteMapping("/deleteUsers/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.userServices.deleteUserById(id);
        return HttpStatus.OK;
    }

}
