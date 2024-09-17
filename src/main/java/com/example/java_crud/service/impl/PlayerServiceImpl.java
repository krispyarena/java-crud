package com.example.java_crud.service.impl;

import com.example.java_crud.model.Player;
import com.example.java_crud.repositories.PlayerRepo;
import com.example.java_crud.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public void addPlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepo.deleteById(id);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public Player getPlayerById(Integer id) {
        return playerRepo.findById(id).get();
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }
}
