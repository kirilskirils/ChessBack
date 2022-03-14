package com.chess.chessbackend.payload.request;

import com.chess.chessbackend.payload.request.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginRequestTest {
    private LoginRequest loginRequest = new LoginRequest();

//    @Test
//    void getUsername() {
//        Assertions.assertEquals("Username", LoginRequest.getUsername());
//    }
//
    @Test
    void setUsername() {
        loginRequest.setUsername("Uldis");
        Assertions.assertEquals("Uldis", loginRequest.getUsername());
    }
//
//    @Test
//    void getPassword() {
//        Assertions.assertEquals("Password", LoginRequest.getPassword());
//    }
//
//    @Test
//    void setPassword() {
//        LoginRequest.setPassword("Abc777");
//        Assertions.assertEquals("Abc777", LoginRequest.getPassword());
//    }
}