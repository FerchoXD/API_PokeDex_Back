package com.example.api_pokedex.services.interfaces;

import com.example.api_pokedex.controllers.dtos.response.BaseResponse;

public interface ITrainersLeagueService {
    BaseResponse listAllTrainersByLeagueId(Long leagueId);

    BaseResponse listAllLeaguesByTrainersId(Long trainerId);
}
