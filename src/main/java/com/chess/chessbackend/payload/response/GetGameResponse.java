package com.chess.chessbackend.payload.response;

public class GetGameResponse
{
    private Long playerId;
    private Long opponentId;
    private String gameState;
    private String gameStatus;

    public GetGameResponse(Long playerId, Long opponentId, String gameState, String gameStatus)
    {
        this.playerId = playerId;
        this.opponentId = opponentId;
        this.gameState = gameState;
        this.gameStatus = gameStatus;
    }

    public Long getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(Long playerId)
    {
        this.playerId = playerId;
    }

    public Long getOpponentId()
    {
        return opponentId;
    }

    public void setOpponentId(Long opponentId)
    {
        this.opponentId = opponentId;
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
}

