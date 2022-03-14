package com.chess.chessbackend.payload.response;

public class GetActiveGameResponse
{
    private Long gameId;
    public GetActiveGameResponse(Long gameId)
    {
        this.gameId = gameId;
    }

    public Long getGameId()
    {
        return gameId;
    }

    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }
}
