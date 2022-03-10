package com.chess.chessbackend.controllers;


import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.request.*;
import com.chess.chessbackend.payload.response.GetGameResponse;
import com.chess.chessbackend.payload.response.MessageResponse;
import com.chess.chessbackend.repository.GameRepository;
import com.chess.chessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.chess.chessbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.response.JwtResponse;
import com.chess.chessbackend.payload.response.MessageResponse;
import com.chess.chessbackend.repository.UserRepository;
import com.chess.chessbackend.security.jwt.JwtUtils;
import com.chess.chessbackend.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
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
        Game game = new Game(userRepository.findByUsername(gameRequest.getPlayerName()).get().getId(), null, null, "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        gameRepository.save(game);

        return ResponseEntity.ok(new MessageResponse("Game Created"));
    }

    @PostMapping("/join")
    public ResponseEntity<?> createGame(@Valid @RequestBody JoinGameRequest joinGameRequest)
    {
        Game game = gameRepository.getById(joinGameRequest.getGameId());

        Optional<User> user = userRepository.findByUsername(joinGameRequest.getPlayerName());

        if(game.getFirstPlayerId() != null && game.getSecondPlayerId() == null)
        {
            game.setSecondPlayerId(user.get().getId());
            game.setGameStatus("READY");
        }
        gameRepository.save(game);

        return ResponseEntity.ok(new MessageResponse("Game Joined"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGame(@PathVariable long id)
    {
        System.out.println("ID: " + id);
        Game game = gameRepository.getById(id);

        if(gameRepository.existsById(id))
        {
            return ResponseEntity.ok(new GetGameResponse(game.getFirstPlayerId(),game.getSecondPlayerId(),game.getGameState(),game.getGameStatus()));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Game not found"));
        }


    }



}
