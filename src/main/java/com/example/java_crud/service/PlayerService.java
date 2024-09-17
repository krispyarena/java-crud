package com.example.java_crud.service;

import com.example.java_crud.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    void addPlayer(Player player);

    void deletePlayer(Integer id);

    void updatePlayer(Player player);

    Player getPlayerById(Integer id);

    List<Player> getAllPlayers();
}
