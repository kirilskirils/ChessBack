package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class CreateGameRequest
{
    @NotNull
    private String playerName;

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }


}
