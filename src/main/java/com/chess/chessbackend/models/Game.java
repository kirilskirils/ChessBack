package com.chess.chessbackend.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Optional;


@Entity
    @Table(name = "game")
    public class Game
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "first_user_id")
        private User firstPlayer;

        @ManyToOne
        @JoinColumn(name = "second_user_id")
        private User secondPlayer;

        @Column(columnDefinition = "varchar(50) default 'New'")
        @Size(max = 150)
        private String gameStatus;

        @Column(columnDefinition = "varchar(150)")
        @Size(max = 150)
        private String gameState;

        public Game()
        {

        }

        public Game(User firstPlayer, User secondPlayer, String gameStatus, String gameState)
        {
            this.firstPlayer = firstPlayer;
            this.secondPlayer = secondPlayer;

            this.gameStatus = gameStatus;
            this.gameState = gameState;
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

        public User getSecondPlayer()
        {
            return secondPlayer;
        }

        public void setSecondPlayer(User secondPlayer)
        {
            this.secondPlayer = secondPlayer;
        }

        public User getFirstPlayer()
        {
            return firstPlayer;
        }

        public void setFirstPlayer(User firstPlayer)
        {
            this.firstPlayer = firstPlayer;
        }

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        {
            this.id = id;
        }
    }

