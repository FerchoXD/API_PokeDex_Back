package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerForumResponse {
    private Long id;

    private String age;

    private String name;

    private String category;

    private String email;
    private String image;

    private String forumsTopic;

    private String forumsId;

    private String leaguesName;
}
