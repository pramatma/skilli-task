package com.skilli.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilli.application.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
