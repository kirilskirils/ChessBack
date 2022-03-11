package com.chess.chessbackend.payload.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SignupRequestTest {
    private SignupRequest SignupRequest = new SignupRequest("username", "password");

    @Test
    void getUsername() {
        Assertions.assertEquals("Username", SignupRequest.getUsername());
    }

    @Test
    void setUsername() {
        SignupRequest.setUsername("Gints");
        Assertions.assertEquals("Gints", SignupRequest.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("Password", SignupRequest.getPassword());
    }

    @Test
    void setPassword() {
        SignupRequest.setPassword("bootcamp01");
        Assertions.assertEquals("bootcamp01", SignupRequest.getPassword());
    }
}