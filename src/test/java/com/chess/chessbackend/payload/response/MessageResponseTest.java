package com.chess.chessbackend.payload.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageResponseTest {

    public MessageResponse MessageResponse = new MessageResponse("message");

    @Test
    void getMessage() {
        Assertions.assertEquals("Username", MessageResponse.getMessage());
    }

    @Test
    void setMessage() {
        MessageResponse.setMessage("Hello");
        Assertions.assertEquals("Hello", MessageResponse.getMessage());
    }
}