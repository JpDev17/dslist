package com.JpDev17.dslist.services;

import com.JpDev17.dslist.dto.GameMinDTO;
import com.JpDev17.dslist.entities.Game;
import com.JpDev17.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
