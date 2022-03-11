package com.chess.chessbackend.payload.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginRequestTest {
    private LoginRequest LoginRequest = new LoginRequest("username", "password");

    @Test
    void getUsername() {
        Assertions.assertEquals("Username", LoginRequest.getUsername());
    }

    @Test
    void setUsername() {
        LoginRequest.setUsername("Uldis");
        Assertions.assertEquals("Uldis", LoginRequest.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("Password", LoginRequest.getPassword());
    }

    @Test
    void setPassword() {
        LoginRequest.setPassword("Abc777");
        Assertions.assertEquals("Abc777", LoginRequest.getPassword());
    }
}