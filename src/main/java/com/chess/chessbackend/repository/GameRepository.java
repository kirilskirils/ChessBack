package com.chess.chessbackend.repository;

import com.chess.chessbackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
    boolean existsById(Long id);
}
