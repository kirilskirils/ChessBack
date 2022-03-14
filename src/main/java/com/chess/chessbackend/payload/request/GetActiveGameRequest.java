package com.chess.chessbackend.payload.request;

public class GetActiveGameRequest
{
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
