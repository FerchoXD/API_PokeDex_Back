package com.example.api_pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class CreateTrainerRequest {

    private String name;

    private String password;

    private String age;

    private String email;

    private String category;

    private String image;
}
