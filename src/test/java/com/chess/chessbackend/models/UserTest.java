package com.chess.chessbackend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user = new User("username", "password");

    @Test
    void getId() {
        Assertions.assertEquals(1l, user.getId());
    }

    @Test
    void setId() {
        user.setId(2l);
        Assertions.assertEquals(2l, user.getId());
    }

    @Test
    void getUsername() {
        Assertions.assertEquals("Username", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("Somebody");
        Assertions.assertEquals("Somebody", user.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("Password", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("qwerty123");
        Assertions.assertEquals("qwerty123", user.getPassword());
    }
}