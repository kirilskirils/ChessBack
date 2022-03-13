package com.chess.chessbackend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private User user1 = new User("username1","password");
    private User user2 = new User("username2","password");
    private Game game = new Game(user1, user2, "Status", "State");


    @Test
    void setSecondPlayerId() {
        game.getSecondPlayer().setId(3L);
        Assertions.assertEquals(3L, game.getSecondPlayer().getId());
    }

//    @Test
//    void getFirstPlayerId() {
//        Assertions.assertEquals(1l, game.getFirstPlayer().getId());
//    }

    @Test
    void setFirst_player_id() {
    }

    @Test
    void getGame_status() {
    }

    @Test
    void setGame_status() {
    }

    @Test
    void getGame_state() {
    }

    @Test
    void setGame_state() {
    }
}