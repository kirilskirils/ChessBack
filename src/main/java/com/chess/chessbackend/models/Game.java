package com.chess.chessbackend.models;

import javax.persistence.*;
import javax.validation.constraints.Size;


    @Entity
    @Table(name = "game")
    public class Game
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @OneToOne
        @JoinColumn(name = "first_player_id")
        private User firstPlayer;

        @OneToOne
        @JoinColumn(name = "second_player_id")
        private User secondPlayer;


        private Long firstPlayerId;

        private Long secondPlayerId;

        @Column(columnDefinition = "varchar(50) default 'New'")
        @Size(max = 150)
        private String gameStatus;

        @Column(columnDefinition = "varchar(150)")
        @Size(max = 150)
        private String gameState;

        public User getFirstPlayer()
        {
            return firstPlayer;
        }

        public Game()
        {
        }

        public Game(Long firstPlayerId, Long secondPlayerId, String gameStatus,String gameState)
        {
            this.firstPlayerId = firstPlayerId;
            this.secondPlayerId = secondPlayerId;
            this.gameStatus = gameStatus;
            this.gameState = gameState;
        }

        public Long getSecondPlayerId()
        {
            return secondPlayerId;
        }

        public void setSecondPlayerId(Long secondPlayerId)
        {
            this.secondPlayerId = secondPlayerId;
        }

        public Long getFirstPlayerId()
        {
            return firstPlayerId;
        }

        public void setFirstPlayerId(Long firstPlayerId)
        {
            this.firstPlayerId = firstPlayerId;
        }

        public String getGameStatus()
        {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus)
        {
            this.gameStatus = gameStatus;
        }

        public String getGameState()
        {
            return gameState;
        }

        public void setGameState(String gameState)
        {
            this.gameState = gameState;
        }
    }

