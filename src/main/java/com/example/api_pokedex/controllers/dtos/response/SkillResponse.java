package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillResponse {
    private Long id;

    private String name;

    private String effect;

    private String type;

    private String pokemonsName;
}
