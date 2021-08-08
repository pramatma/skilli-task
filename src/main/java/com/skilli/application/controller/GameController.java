package com.skilli.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilli.application.model.Game;
import com.skilli.application.services.GameServices;

@RestController
@RequestMapping("/api/v1/admin")
public class GameController {
	
	@Autowired
	GameServices gameServices;
	
	@GetMapping("/")
    public ResponseEntity<String> gameHome() {
        return ResponseEntity.ok("Yeah.., You must be admin");
    }
	
	@PostMapping("/add-games")
    public ResponseEntity<Game> addGame(@RequestBody Game game) { 
		System.out.println("game inside controller :"+ game);
        return ResponseEntity.ok(this.gameServices.addGame(game));
    }
	
	@GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames() {
		return ResponseEntity.ok(this.gameServices.getAllGames());
    }
	
	@PutMapping("/game/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable(value = "id") int gameId, @RequestBody Game gameDetails) throws Exception{
		Game updatedGame = null;
		try {
			Game game = this.gameServices.findGameById(gameId);
			game.setTitle(gameDetails.getTitle());
			game.setCategory(gameDetails.getCategory());
			game.setImageUrl(gameDetails.getImageUrl());
			updatedGame = this.gameServices.updateGame(game);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return ResponseEntity.ok(updatedGame);
	}
	
	@DeleteMapping("/delete-game/{id}")
    public HttpStatus deleteGame(@PathVariable int id) {
        this.gameServices.deleteGame(id);
        return HttpStatus.OK;
    }
	
	
	
	
	
	
	

}
