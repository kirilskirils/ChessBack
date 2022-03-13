package com.chess.chessbackend.controllers;


import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.request.*;
import com.chess.chessbackend.payload.response.GetAllGameResponse;
import com.chess.chessbackend.payload.response.GetGameResponse;
import com.chess.chessbackend.payload.response.MessageResponse;
import com.chess.chessbackend.repository.GameRepository;
import com.chess.chessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
//@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/game")
public class GameController
{
    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public ResponseEntity<?> createGame(@Valid @RequestBody CreateGameRequest gameRequest)
    {
        Optional<User> user = userRepository.findByUsername(gameRequest.getPlayerName());
        if (user.isPresent())
        {
            Game game = new Game(user.get(), null, "CREATED", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

            gameRepository.save(game);
            return ResponseEntity.ok(new MessageResponse("Game Created"));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User not found"));
        }

    }


    @PostMapping("/join")
    public ResponseEntity<?> createGame(@Valid @RequestBody JoinGameRequest joinGameRequest)
    {
        Game game = gameRepository.getById(joinGameRequest.getGameId());

        Optional<User> user = userRepository.findByUsername(joinGameRequest.getPlayerName());

        if (!user.isPresent())
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Failed getting user in joining request"));
        }

        if (game.getFirstPlayer() != null && game.getSecondPlayer() == null)
        {
            game.setSecondPlayer(user.get());
            game.setGameStatus("READY");
            gameRepository.save(game);
            return ResponseEntity.ok(new MessageResponse("Game Joined"));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Failed joining game"));

        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGame(@PathVariable long id)
    {

        Game game = gameRepository.getById(id);

        if (gameRepository.existsById(id))
        {
            String username = null;
            if (game.getSecondPlayer() != null)
            {
                username = game.getSecondPlayer().getUsername();
            }
            GetGameResponse response = new GetGameResponse(
                    id,
                    game.getFirstPlayer().getUsername(),
                    username,
                    game.getGameState(),
                    game.getGameStatus()
            );

            return ResponseEntity.ok(response);
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Game not found"));
        }


    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllGames()
    {
        List<Game> gamesList = gameRepository.findAll();
        List<GetAllGameResponse> gamesResponseList = new ArrayList<>();
        for (Game game : gamesList)
        {
            String username = null;
            if (game.getSecondPlayer() != null)
            {
                username = game.getSecondPlayer().getUsername();
            }
            gamesResponseList.add(new GetAllGameResponse(
                    game.getId(),
                    game.getFirstPlayer().getUsername(),
                    username,
                    game.getGameState(),
                    game.getGameStatus()
            ));
        }
        return ResponseEntity.ok(gamesResponseList);
    }




}
