package com.example.java_crud.controller;

import com.example.java_crud.model.Player;
import com.example.java_crud.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<Player>> getAllPlayers() {
        try{
            List<Player> playerList = new ArrayList<>();
            playerRepo.findAll().forEach(playerList::add);

            if(playerList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(playerList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        Optional<Player> playerData = playerRepo.findById(id);

        if(playerData.isPresent()) {
            return new ResponseEntity<>(playerData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/updatePlayerById/{id}")
    public ResponseEntity<Player> updatePlayerById(@PathVariable Integer id, @RequestBody Player newPlayerData) {
        Optional<Player> oldPlayerData = playerRepo.findById(id);

        if(oldPlayerData.isPresent()) {
            Player updatedPlayerData = oldPlayerData.get();
            updatedPlayerData.setName(newPlayerData.getName());
            updatedPlayerData.setCountry(newPlayerData.getCountry());
            updatedPlayerData.setGoals(newPlayerData.getGoals());
            Player player = playerRepo.save(updatedPlayerData);

            return new ResponseEntity<>(player, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player playerObj = playerRepo.save(player);
        return new ResponseEntity<>(playerObj, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePlayerById/{id}")
    public ResponseEntity<HttpStatus> deletePlayerById(@PathVariable Integer id) {
        playerRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
