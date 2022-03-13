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
@RequestMapping("/api/move")
public class MoveController
{
    @Autowired
    GameRepository gameRepository;

    @PostMapping("/makemove")
    public ResponseEntity<?> makeMove(@RequestBody MakeMoveRequest moveRequest)
    {
        if (gameRepository.existsById(moveRequest.getGameId()))
        {
            Game game = gameRepository.getById(moveRequest.getGameId());
            game.setGameState(moveRequest.getFen());
            gameRepository.save(game);
            return ResponseEntity.ok(new MessageResponse("Move success"));

        }

        return ResponseEntity.badRequest().body(new MessageResponse("Error: problem making a move"));
    }
}
