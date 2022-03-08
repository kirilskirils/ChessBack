package com.chess.chessbackend.models;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;


    @Entity
    @Table(name = "game")
    public class Game
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long first_player_id;

        private Long second_player_id;

        @Column(columnDefinition = "varchar(50) default 'New'")
        @Size(max = 100)
        private String game_status;

        @Column(columnDefinition = "varchar(50) default 'FEN'")
        @Size(max = 100)
        private String game_state;

        public Game()
        {
        }

        public Game(Long first_player_id, Long second_player_id, String game_status,String game_state)
        {
            this.first_player_id = first_player_id;
            this.second_player_id = second_player_id;
            this.game_status = game_status;
            this.game_state = game_state;
        }

        public Long getSecond_player_id()
        {
            return second_player_id;
        }

        public void setSecond_player_id(Long second_player_id)
        {
            this.second_player_id = second_player_id;
        }

        public Long getFirst_player_id()
        {
            return first_player_id;
        }

        public void setFirst_player_id(Long first_player_id)
        {
            this.first_player_id = first_player_id;
        }

        public String getGame_status()
        {
            return game_status;
        }

        public void setGame_status(String game_status)
        {
            this.game_status = game_status;
        }

        public String getGame_state()
        {
            return game_state;
        }

        public void setGame_state(String game_state)
        {
            this.game_state = game_state;
        }
    }

