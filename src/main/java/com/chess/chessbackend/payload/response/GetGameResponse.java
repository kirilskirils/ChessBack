package com.chess.chessbackend.payload.response;

public class GetGameResponse
{
    private Long firstPlayerId;
    private Long secondPlayerId;
    private String gameState;
    private String gameStatus;

    public GetGameResponse(Long playerId, Long opponentId, String gameState, String gameStatus)
    {
        this.firstPlayerId = playerId;
        this.secondPlayerId = opponentId;
        this.gameState = gameState;
        this.gameStatus = gameStatus;
    }

    public Long getFirstPlayerId()
    {
        return firstPlayerId;
    }

    public void setFirstPlayerId(Long firstPlayerId)
    {
        this.firstPlayerId = firstPlayerId;
    }

    public Long getSecondPlayerId()
    {
        return secondPlayerId;
    }

    public void setSecondPlayerId(Long secondPlayerId)
    {
        this.secondPlayerId = secondPlayerId;
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

