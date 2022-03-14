package com.chess.chessbackend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private static User firstUser;
    private static User secondUser;
    private static Game game;

    @BeforeEach
     void setUp(){
        firstUser = new User("Name", "Password", 1L);
        secondUser = new User("Name", "Password", 1L);
        game = new Game(firstUser, secondUser, "Status", "State");
        game.setId(1l);
    }

    @Test
    void getGameStatus() {
        Assertions.assertEquals("Status", game.getGameStatus());
    }

    @Test
    void setGameStatus() {
        game.setGameStatus("Status2");
        Assertions.assertEquals("Status2", game.getGameStatus());
    }

    @Test
    void getGameState() {
        Assertions.assertEquals("State", game.getGameState());
    }

    @Test
    void setGameState() {
        game.setGameState("Playing");
        Assertions.assertEquals("Playing", game.getGameState());
    }

    @Test
    void getSecondPlayer() {
        Assertions.assertEquals(secondUser, game.getSecondPlayer());
    }

    @Test
    void setSecondPlayer() {
        game.setSecondPlayer(secondUser);
        Assertions.assertEquals(secondUser, game.getSecondPlayer());
    }

    @Test
    void getFirstPlayer() {
        Assertions.assertEquals(firstUser, game.getFirstPlayer());
    }

    @Test
    void setFirstPlayer() {
        game.setFirstPlayer(firstUser);
        Assertions.assertEquals(firstUser, game.getFirstPlayer());
    }

    @Test
    void getId() {
        Assertions.assertEquals(1l, game.getId());
    }

    @Test
    void setId() {
        game.setId(2l);
        Assertions.assertEquals(2l, game.getId());
    }
}