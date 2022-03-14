package com.chess.chessbackend.payload.request;

import com.chess.chessbackend.payload.request.CreateGameRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateGameRequestTest {



    private CreateGameRequest createGameRequest = new CreateGameRequest();

    @BeforeEach
    void setUp() {
        createGameRequest.setPlayerName("username");
    }

    @Test
    void getPlayer_name() {
        Assertions.assertEquals("username", createGameRequest.getPlayerName());
    }

    @Test
    void setPlayer_name() {
        createGameRequest.setPlayerName("Karlis");
        Assertions.assertEquals("Karlis", createGameRequest.getPlayerName());
    }
}