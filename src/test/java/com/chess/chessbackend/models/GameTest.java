package com.chess.chessbackend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game = new Game(1l, 2l, "Status", "State");

    @Test
    void getSecond_player_id() {
        Assertions.assertEquals(2l, game.getSecond_player_id());
    }

    @Test
    void setSecond_player_id() {
        game.setSecond_player_id(3l);
        Assertions.assertEquals(3l, game.getSecond_player_id());
    }

    @Test
    void getFirst_player_id() {
        Assertions.assertEquals(1l, game.getFirst_player_id());
    }

    @Test
    void setFirst_player_id() {
        game.setFirst_player_id(2l);
        Assertions.assertEquals(2l, game.getFirst_player_id());
    }

    @Test
    void getGame_status() {
        Assertions.assertEquals("Status", game.getGame_status());
    }

    @Test
    void setGame_status() {
        game.setGame_status("Playing");
        Assertions.assertEquals("Playing", game.getGame_status());
    }

    @Test
    void getGame_state() {
        Assertions.assertEquals("State", game.getGame_state());
    }

    @Test
    void setGame_state() {
        game.setGame_state("C7");
        Assertions.assertEquals("C7", game.getGame_state());
    }
}