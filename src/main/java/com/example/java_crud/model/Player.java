package com.example.java_crud.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class Player {

    private Integer id;
    private String name;
    private String country;
    private int goals;
}
