package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateGameRequest
{

    private Long first_player_id;

    private Long second_player_id;

    private String game_status;

    public Long getFirst_player_id()
    {
        return first_player_id;
    }

    public void setFirst_player_id(Long first_player_id)
    {
        this.first_player_id = first_player_id;
    }

    public Long getSecond_player_id()
    {
        return second_player_id;
    }

    public String getGame_status()
    {
        return game_status;
    }

    public void setGame_status(String game_status)
    {
        this.game_status = game_status;
    }

    public void setSecond_player_id(Long second_player_id)
    {
        this.second_player_id = second_player_id;
    }
}
