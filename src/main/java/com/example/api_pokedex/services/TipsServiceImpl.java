package com.example.api_pokedex.services;

import com.example.api_pokedex.controllers.dtos.request.CreateTipsRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateTipsRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetTipsResponse;
import com.example.api_pokedex.controllers.dtos.response.TipsResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateTipsResponse;
import com.example.api_pokedex.entities.Tips;
import com.example.api_pokedex.entities.projections.TipsProjections;
import com.example.api_pokedex.repositories.ITipsRepository;
import com.example.api_pokedex.services.interfaces.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipsServiceImpl implements ITipsService {
    @Autowired
    private ITipsRepository repository;

    @Override
    public GetTipsResponse get(Long id) {
        Tips tips = find(id);
        return from(tips);
    }

    @Override
    public BaseResponse create(CreateTipsRequest request) {
        Tips tips = to(request);
        return BaseResponse.builder()
                .data(from(repository.save(tips)))
                .message("tip created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public UpdateTipsResponse update(UpdateTipsRequest request, Long id) {
        Tips tips = find(id);
        tips.setDescription(request.getDescription());
        tips.setImage(request.getImage());
        repository.save(tips);
        return fromUpdate(tips);
    }

    @Override
    public List<GetTipsResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TipsResponse> listAllTipsByTrainersId(Long trainersId) {
        List<TipsProjections> tips = repository.listAllTrainersByPokemonId(trainersId);
        return tips.stream().map(this::from).collect(Collectors.toList());
        }

    @Override
    public Tips FindOneAndEnsurePicture(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("El tip no se encontro"));

    }

    public Tips save(Tips tips) {
        return repository.save(tips);
    }

    private TipsResponse from (TipsProjections tips){
        TipsResponse response = new TipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }

    public Tips to(CreateTipsRequest request) {
        Tips tips = new Tips();
        tips.setDescription(request.getDescription());
        tips.setImage(request.getImage());
        return tips;
    }

    public GetTipsResponse from(Tips tips) {
        GetTipsResponse response = new GetTipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }

    public UpdateTipsResponse fromUpdate(Tips tips) {
        UpdateTipsResponse response = new UpdateTipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }
    public Tips find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
