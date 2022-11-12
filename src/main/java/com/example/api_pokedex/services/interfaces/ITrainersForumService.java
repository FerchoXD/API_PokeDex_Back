package com.example.api_pokedex.services.interfaces;

import com.example.api_pokedex.controllers.dtos.response.BaseResponse;

public interface ITrainersForumService {

    BaseResponse listAllTrainersByForumId(Long forumId);
}
