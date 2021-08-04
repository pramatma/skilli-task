package com.skilli.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilli.application.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
