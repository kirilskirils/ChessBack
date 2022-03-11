package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class JoinGameRequest
{
    @NotNull
    private Long gameId;

    @NotNull
    private String playerName;


    public Long getGameId()
    {
        return gameId;
    }

    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
}
