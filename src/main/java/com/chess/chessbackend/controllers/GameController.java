package com.chess.chessbackend.controllers;


import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.payload.request.CreateGameRequest;
import com.chess.chessbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/game")
public class GameController
{
    @Autowired
    GameRepository gameRepository;

    @PostMapping("/create")
    public String createGame(@Valid @RequestBody CreateGameRequest gameRequest)
    {
        Game game = new Game(gameRequest.getFirst_player_id(),gameRequest.getSecond_player_id(),gameRequest.getGame_status());
       gameRepository.save(game);

        return "game created";
    }


}
