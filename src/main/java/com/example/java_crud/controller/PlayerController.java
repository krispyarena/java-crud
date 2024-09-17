package com.example.java_crud.controller;

import com.example.java_crud.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;
}
