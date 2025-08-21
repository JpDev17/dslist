package com.JpDev17.dslist.repositories;

import com.JpDev17.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
