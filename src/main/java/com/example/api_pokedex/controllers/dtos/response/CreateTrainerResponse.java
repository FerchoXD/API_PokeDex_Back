package com.example.api_pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTrainerResponse {
    private Long id;

    private String name;


    private String password;

    private String email;
    private String age;

    private String category;

    private String image;
}
