package com.chess.chessbackend.payload.response;

public class GetGameResponse
{
    private Long gameId;
    private String playerName;
    private String opponentName;
    private String gameState;
    private String gameStatus;

    public GetGameResponse(Long gameId, String playerName, String opponentName, String gameState, String gameStatus)
    {
        this.gameId = gameId;
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.gameState = gameState;
        this.gameStatus = gameStatus;
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

    public String getOpponentName()
    {
        return opponentName;
    }

    public void setOpponentName(String opponentName)
    {
        this.opponentName = opponentName;
    }
}

