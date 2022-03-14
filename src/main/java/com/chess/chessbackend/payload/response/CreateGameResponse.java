package com.chess.chessbackend.payload.response;

public class CreateGameResponse
{
    private Long gameId;

    public CreateGameResponse(Long gameId)
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
