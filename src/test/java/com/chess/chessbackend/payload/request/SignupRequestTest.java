package com.chess.chessbackend.payload.request;

import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.request.SignupRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SignupRequestTest {
    private SignupRequest signUp = new SignupRequest();

    @BeforeEach
    void setUp() {
        signUp.setUsername("username");
        signUp.setPassword("qwerty123");
    }


    @Test
    void setUsername() {
        signUp.setUsername("Pauls");
        Assertions.assertEquals("Pauls", signUp.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("qwerty123", signUp.getPassword());
    }

    @Test
    void setPassword() {
        signUp.setPassword("bootcamp01");
        Assertions.assertEquals("bootcamp01", signUp.getPassword());
    }
}