package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokeballResponse {
    private Long id;

    private String name;

    private String level;

    private String recommendation;
}
