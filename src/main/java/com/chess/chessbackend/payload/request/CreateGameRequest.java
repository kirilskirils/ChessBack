package com.chess.chessbackend.payload.request;

import javax.validation.constraints.NotNull;

public class CreateGameRequest
{
    @NotNull
    private Long userId;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}
