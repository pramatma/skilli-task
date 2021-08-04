package com.skilli.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilli.application.exceptions.ResourceNotFoundException;
import com.skilli.application.model.Users;
import com.skilli.application.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public Users createUser(Users user) {
        return userRepository.save(user);
	}

	public String deleteUserById(int id) {
	        userRepository.deleteById(id);
	        return "User "+ id +" deleted";
	}

	public List<Users> getUserList() {
		return userRepository.findAll();
	}
	
	public Users findUserById(int userId) throws ResourceNotFoundException {
		Users user = userRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return user;
	}

	public Users findByUsername(String username){
		Users user = userRepository.findByUsername(username);
		return user;
	}
	

}
