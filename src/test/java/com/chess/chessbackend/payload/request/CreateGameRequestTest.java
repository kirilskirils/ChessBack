package com.chess.chessbackend.payload.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateGameRequestTest {

    private final CreateGameRequest createGameRequest = new CreateGameRequest();

    @BeforeEach
    void setUp() {
        createGameRequest.setUserId(1L);
    }

    @Test
    void getPlayer_name() {
        Assertions.assertEquals(1, createGameRequest.getUserId());
    }

//    @Test
//    void setPlayer_name() {
//        createGameRequest.setPlayerName("Karlis");
//        Assertions.assertEquals("Karlis", createGameRequest.getPlayerName());
//    }
}