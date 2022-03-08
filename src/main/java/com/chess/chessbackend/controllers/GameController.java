package com.chess.chessbackend.controllers;


import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.payload.request.CreateGameRequest;
import com.chess.chessbackend.payload.response.MessageResponse;
import com.chess.chessbackend.repository.GameRepository;
import com.chess.chessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/game")
public class GameController
{
    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public ResponseEntity<?> createGame(@Valid @RequestBody CreateGameRequest gameRequest)
    {
        Game game = new Game(userRepository.findByUsername(gameRequest.getPlayer_name()).get().getId(), null, null, null);
        gameRepository.save(game);

        return ResponseEntity.ok(new MessageResponse("Game Created"));
    }


}
