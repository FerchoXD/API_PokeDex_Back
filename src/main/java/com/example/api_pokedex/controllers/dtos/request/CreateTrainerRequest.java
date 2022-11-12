package com.example.api_pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CreateTrainerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String age;

    private String category;

    private String image;
}
