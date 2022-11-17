package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class TrainerResponse {
    private Long id;

    private String name;

    private String password;

    private String age;

    private String category;

    private String image;
}
