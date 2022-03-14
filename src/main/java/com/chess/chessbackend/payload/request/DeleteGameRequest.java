package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class DeleteGameRequest

{
    @NotNull
    private Long playerId;


    public Long getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(Long playerId)
    {
        this.playerId = playerId;
    }
}

