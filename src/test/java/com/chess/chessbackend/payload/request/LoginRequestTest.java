package com.chess.chessbackend.payload.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginRequestTest {
    private final LoginRequest loginRequest = new LoginRequest();

    @BeforeEach
    void setUp() {
        loginRequest.setUsername("username");
        loginRequest.setPassword("qwerty123");
    }

    @Test
    void getUsername() {
        Assertions.assertEquals("username", loginRequest.getUsername());
    }

    @Test
    void setUsername() {
        loginRequest.setUsername("Uldis");
        Assertions.assertEquals("Uldis", loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("qwerty123", loginRequest.getPassword());
    }

    @Test
    void setPassword() {
        loginRequest.setPassword("Abc777");
        Assertions.assertEquals("Abc777", loginRequest.getPassword());
    }
}