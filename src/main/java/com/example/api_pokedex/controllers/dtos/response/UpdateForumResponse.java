package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateForumResponse {
    private Long id;

    private String topic;

    private String date;

    private String hour;
}
