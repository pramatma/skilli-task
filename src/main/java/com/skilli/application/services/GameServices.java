package com.skilli.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilli.application.exceptions.ResourceNotFoundException;
import com.skilli.application.model.Game;
import com.skilli.application.repository.GameRepository;

@Service
public class GameServices {
	
	@Autowired
	GameRepository gameRepository;
	
	public Game addGame(Game game) {
        return gameRepository.save(game);
	}
	
	public String deleteGame(int id) {
		gameRepository.deleteById(id);
        return "Game "+ id +" deleted";
	}
	
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}
	
	public Game findGameById(int gameId) throws ResourceNotFoundException {
		Game user = gameRepository.findById(gameId)
		.orElseThrow(() -> new ResourceNotFoundException("Game not found :: " + gameId));
		return user;
	}

	public Game updateGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
