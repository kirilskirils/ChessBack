package com.chess.chessbackend.payload.response;

public class GetAllGameResponse
{
    private Long id;
    private String firstPlayer;
    private String opponentPlayer;
    private String gameState;
    private String gameStatus;

    public GetAllGameResponse(Long id, String firstPlayer, String opponentPlayer, String gameState, String gameStatus)
    {
        this.id = id;
        this.firstPlayer = firstPlayer;
        this.opponentPlayer = opponentPlayer;
        this.gameState = gameState;
        this.gameStatus = gameStatus;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstPlayer()
    {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer)
    {
        this.firstPlayer = firstPlayer;
    }

    public String getOpponentPlayer()
    {
        return opponentPlayer;
    }

    public void setOpponentPlayer(String opponentPlayer)
    {
        this.opponentPlayer = opponentPlayer;
    }

    public String getGameState()
    {
        return gameState;
    }

    public void setGameState(String gameState)
    {
        this.gameState = gameState;
    }

    public String getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus)
    {
        this.gameStatus = gameStatus;
    }
}
