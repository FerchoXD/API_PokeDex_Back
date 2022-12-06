package com.example.api_pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    private String title;
    private String description;
}
