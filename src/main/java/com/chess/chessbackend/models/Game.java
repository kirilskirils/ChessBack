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

    @OneToOne(optional = false)
    @JoinColumn(name = "first_player_id", nullable = false)
    private User firstPlayer;

    @OneToOne
    @JoinColumn(name = "second_player_id", unique = true)
    private User secondPlayer;

    @Column(columnDefinition = "varchar(50) default 'New'")
    @Size(max = 150)
    private String gameStatus;

    @Column(columnDefinition = "varchar(150)")
    @Size(max = 150)
    private String gameState;

    private Long whitePlayerId;

    public Game()
    {

    }

    public Game(User firstPlayer, User secondPlayer, Long whitePlayerId, String gameStatus, String gameState)
    {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.whitePlayerId = whitePlayerId;
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

    public Long getWhitePlayerId()
    {
        return whitePlayerId;
    }

    public void setWhitePlayerId(Long firstPlayerId)
    {
        this.whitePlayerId = firstPlayerId;
    }
}

