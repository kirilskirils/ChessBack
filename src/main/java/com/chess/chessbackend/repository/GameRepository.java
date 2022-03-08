package com.chess.chessbackend.repository;

import com.chess.chessbackend.models.Game;
import com.chess.chessbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
}
