package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class JoinGameRequest
{
    @NotNull
    private Long gameId;

    @NotNull
    private Long userId;


    public Long getGameId()
    {
        return gameId;
    }

    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}
