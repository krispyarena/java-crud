package com.example.java_crud.repositories;

import com.example.java_crud.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
}
