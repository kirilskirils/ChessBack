package com.chess.chessbackend.controllers;


import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.request.*;
import com.chess.chessbackend.payload.response.*;
import com.chess.chessbackend.repository.GameRepository;
import com.chess.chessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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

    /**
     * POST for creating new game
     * @param createGameRequest request body
     * @return id of created game or error message
     */
    @PostMapping("/create")
    public ResponseEntity<?> createGame(@Valid @RequestBody CreateGameRequest createGameRequest)
    {
        System.out.println(createGameRequest.getUserId());
        Optional<User> user = userRepository.findById(createGameRequest.getUserId());
        if (user.isPresent())
        {
            Game game = new Game  (user.get(), null, null ,"AWAITING OPPONENT", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

            var ent = gameRepository.save(game);

            return ResponseEntity.ok(new CreateGameResponse(ent.getId()));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User not found"));
        }

    }


    /**
     * POST for joining game
     * @param joinGameRequest request body
     * @return Response message with success or failure
     */
    @PostMapping("/join")
    public ResponseEntity<?> joinGame(@Valid @RequestBody JoinGameRequest joinGameRequest)
    {
        Optional<Game> gameOptional= gameRepository.findById(joinGameRequest.getGameId());
        Optional<User> userOptional = userRepository.findById(joinGameRequest.getUserId());
        Game game = new Game();
        User user = new User();
        if (!userOptional.isPresent())
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Failed getting user in joining request"));
        }
        if (gameOptional.isPresent() && userOptional.isPresent())
        {
            game = gameOptional.get();
            user = userOptional.get();
        }

        if (game.getFirstPlayer() != null && game.getSecondPlayer() == null)
        {
            game.setSecondPlayer(user);
            game.setGameStatus("ONGOING");
            if(new Random().nextBoolean())
            {
                game.setWhitePlayerId(game.getFirstPlayer().getId());
            }
            else
            {
                game.setWhitePlayerId(game.getFirstPlayer().getId());
            }

            gameRepository.save(game);
            return ResponseEntity.ok(new MessageResponse("Game Joined"));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Failed joining game"));

        }

    }

    //FIXME: DELETE METHOD INSTEAD OF POST
    /**
     * POST for deleting game
     * @param deleteGameRequest request body
     * @return Response message with success or failure
     */
    @PostMapping("/delete")
    public ResponseEntity<?> deleteGame(@Valid @RequestBody DeleteGameRequest deleteGameRequest)
    {
        Optional<Game> game = gameRepository.findGameByFirstPlayerId(deleteGameRequest.getPlayerId());

        if (game.isPresent())
        {
            gameRepository.delete(game.get());
            return ResponseEntity.ok(new MessageResponse("Game Deleted"));
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Failed deleting game"));

        }

    }

    /**
     * GET for getting specific GAME
     * @param id id of game
     * @return returns game response body
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGame(@PathVariable long id)
    {

        Game game = gameRepository.getById(id);

        if (gameRepository.existsById(id))
        {
            GetGameResponse response = getGame(game);

            return ResponseEntity.ok(response);
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Game not found"));
        }


    }


    /**
     * GET mapping for retuning all games
     * @return response with all games
     */
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


    /**
     * GET mapping for return current active game of player
     * @param playerId player id
     * @return game response
     */
    @GetMapping("/getActive")
    public ResponseEntity<?> getActiveGame(@RequestParam(name = "playerId") Long playerId)
    {
        Optional<Game> gameOpt1 = gameRepository.findGameByFirstPlayerId(playerId);
        Optional<Game> gameOpt2 = gameRepository.findGameBySecondPlayerId(playerId);
        Game game;
        if(gameOpt1.isPresent())
        {
            game = gameOpt1.get();
            GetGameResponse response = getGame(game);
            return ResponseEntity.ok(response);
     
        }
        else if(gameOpt2.isPresent())
        {
            game = gameOpt2.get();
            GetGameResponse response = getGame(game);
            return ResponseEntity.ok(response);
        }
        else
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Game not found"));
        }
    }

    private GetGameResponse getGame(Game game)
    {
        String username = null;
        if (game.getSecondPlayer() != null)
        {
            username = game.getSecondPlayer().getUsername();
        }
        GetGameResponse response = new GetGameResponse(
                game.getId(),
                game.getWhitePlayerId(),
                game.getFirstPlayer().getUsername(),
                username,
                game.getGameState(),
                game.getGameStatus()
        );
        return response;
    }





}
