package com.chess.chessbackend.repository;

import com.chess.chessbackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
    boolean existsById(Long id);
    Optional<Game> findGameByFirstPlayerId(Long id);
    Optional<Game> findGameBySecondPlayerId(Long id);
    List<Game> findAll();
}
