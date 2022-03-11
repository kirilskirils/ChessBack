package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class GetGameRequest
{
    @NotNull
    private Long gameId;

    public Long getGameId()
    {
        return gameId;
    }

    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }
}
