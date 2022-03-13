package com.chess.chessbackend.payload.request;

public class MakeMoveRequest
{
    private Long gameId;
    private String fen;

    public Long getGameId()
    {
        return gameId;
    }

    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

    public String getFen()
    {
        return fen;
    }

    public void setFen(String fen)
    {
        this.fen = fen;
    }
}
