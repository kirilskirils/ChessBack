package com.chess.chessbackend.payload.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateGameRequestTest {

    private CreateGameRequest createGameRequest = new CreateGameRequest("name");

    @Test
    void getPlayer_name() {
        Assertions.assertEquals("name", createGameRequest.getPlayer_name());
    }

    @Test
    void setPlayer_name() {
        createGameRequest.setPlayer_name("Karlis");
        Assertions.assertEquals("Karlis", createGameRequest.getPlayer_name());
    }
}