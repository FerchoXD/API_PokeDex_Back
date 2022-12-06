package com.example.api_pokedex.services.interfaces;

import com.example.api_pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateTrainerResponse;
import com.example.api_pokedex.entities.Trainer;
import com.example.api_pokedex.entities.projections.TrainerProjections;

import java.util.List;

public interface ITrainerService {
    GetTrainerResponse get(Long id);

    BaseResponse Trainer(String nameTrainer);

    BaseResponse create(CreateTrainerRequest request,TrainerProjections projections);

    UpdateTrainerResponse update(UpdateTrainerRequest request, Long id);

    List<GetTrainerResponse> list();

    void delete(Long id);

    Trainer FindOneAndEnsurePicture(Long id);

    Trainer save(Trainer trainer);

    String encryptPassword(String password);

    boolean verifyPassword(CreateTrainerRequest request, TrainerProjections trainer);
}
