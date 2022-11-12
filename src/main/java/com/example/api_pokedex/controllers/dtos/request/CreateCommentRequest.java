package com.example.api_pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCommentRequest {
    @NotBlank
    private String autor;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
