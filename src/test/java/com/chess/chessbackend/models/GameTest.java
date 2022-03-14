package com.chess.chessbackend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private User user1 = new User("username1","password");
    private User user2 = new User("username2","password");
    private Game game = new Game(user1, user2,null, "Status", "State");


    @Test
    void setSecondPlayerId() {
        game.getSecondPlayer().setId(3L);
        Assertions.assertEquals(3L, game.getSecondPlayer().getId());
    }

//    @Test
//    void getFirstPlayerId() {
//        Assertions.assertEquals(1l, game.getFirstPlayer().getId());
//    }

//    @Test
//    void setFirst_player_id() {
//        game.setFirst_player_id(2l);
//        Assertions.assertEquals(2l, game.getFirst_player_id());
//    }
//
//    @Test
//    void getGame_status() {
//        Assertions.assertEquals("Status", game.getGame_status());
//    }
//
//    @Test
//    void setGame_status() {
//        game.setGame_status("Playing");
//        Assertions.assertEquals("Playing", game.getGame_status());
//    }
//
//    @Test
//    void getGame_state() {
//        Assertions.assertEquals("State", game.getGame_state());
//    }
//
//    @Test
//    void setGame_state() {
//        game.setGame_state("C7");
//        Assertions.assertEquals("C7", game.getGame_state());
//    }
}