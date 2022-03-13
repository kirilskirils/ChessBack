package com.chess.chessbackend.payload.response;

import com.chess.chessbackend.payload.response.MessageResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageResponseTest {

    public com.chess.chessbackend.payload.response.MessageResponse MessageResponse = new MessageResponse("message");

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