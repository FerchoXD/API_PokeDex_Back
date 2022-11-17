package com.example.api_pokedex.services;

import com.example.api_pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateTrainerResponse;
import com.example.api_pokedex.entities.Trainer;
import com.example.api_pokedex.entities.projections.TrainerProjections;
import com.example.api_pokedex.repositories.ITrainerRepository;
import com.example.api_pokedex.services.interfaces.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.api_pokedex.controllers.dtos.response.TrainerResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements ITrainerService {
    @Autowired
    private ITrainerRepository repository;


    @Override
    public GetTrainerResponse get(Long id) {
        Trainer trainer = find(id);
        return from(trainer);
    }

    @Override
    public BaseResponse Trainer(String nameTrainer) {
        TrainerProjections trainer = repository.Trainer(nameTrainer);
        TrainerResponse response = new TrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setPassword(trainer.getPassword());
        response.setCategory(trainer.getCategory());
        response.setImage(trainer.getImage());
        response.setAge(trainer.getAge());

        return BaseResponse.builder()
                .data(response)
                .message("Trainer by Name of Trainer")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(CreateTrainerRequest request) {
        Trainer trainer = to(request);
        return BaseResponse.builder()
                .data(from(repository.save(trainer)))
                .message("Trainer created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public UpdateTrainerResponse update(UpdateTrainerRequest request, Long id) {
        Trainer trainer = find(id);
        trainer.setName(request.getName());
        trainer.setPassword(request.getPassword());
        trainer.setAge(request.getAge());
        trainer.setCategory(request.getCategory());
        trainer.setImage(request.getImage());
        repository.save(trainer);
        return fromUpdate(trainer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Trainer FindOneAndEnsurePicture(Long id) {
       return repository.findById(id).orElseThrow(()->new RuntimeException("El entrenador no se encontro"));

    }

    @Override
    public Trainer save(Trainer trainer) {
        return repository.save(trainer);
    }

    @Override
    public List<GetTrainerResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }


    public Trainer to(CreateTrainerRequest request) {
        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setPassword(request.getPassword());
        trainer.setAge(request.getAge());
        trainer.setImage(request.getImage());
        trainer.setCategory(request.getCategory());
        return trainer;
    }

    public GetTrainerResponse from(Trainer trainer) {
        GetTrainerResponse response = new GetTrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setPassword(trainer.getPassword());
        response.setCategory(trainer.getCategory());
        response.setImage(trainer.getImage());
        response.setAge(trainer.getAge());
        return response;
    }

    public UpdateTrainerResponse fromUpdate(Trainer trainer) {
        UpdateTrainerResponse response = new UpdateTrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setPassword(trainer.getPassword());
        response.setCategory(trainer.getCategory());
        response.setImage(trainer.getImage());
        response.setAge(trainer.getAge());
        return response;
    }
    public Trainer find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
