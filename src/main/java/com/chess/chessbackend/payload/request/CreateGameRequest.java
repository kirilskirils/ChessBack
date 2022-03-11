package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class CreateGameRequest
{
    @NotNull
    private String player_name;

    public String getPlayer_name()
    {
        return player_name;
    }

    public void setPlayer_name(String player_name)
    {
        this.player_name = player_name;
    }

    public CreateGameRequest(String player_name) {
        this.player_name = player_name;
    }

}
