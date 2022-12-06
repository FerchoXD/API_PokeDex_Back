package com.example.api_pokedex.services;

import com.example.api_pokedex.controllers.dtos.request.CreatePokemonRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdatePokemonRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetPokemonResponse;
import com.example.api_pokedex.controllers.dtos.response.PokemonResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdatePokemonResponse;
import com.example.api_pokedex.entities.Pokemon;
import com.example.api_pokedex.repositories.IPokemonRepository;
import com.example.api_pokedex.services.interfaces.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {
    @Autowired
    private IPokemonRepository repository;


    @Override
    public GetPokemonResponse get(Long id) {
        Pokemon pokemon = find(id);
        return from(pokemon);
    }

    @Override
    public BaseResponse create(CreatePokemonRequest request) {
        Pokemon pokemon= to(request);
        return BaseResponse.builder()
                .data(from(repository.save(pokemon)))
                .message("pokemon created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public UpdatePokemonResponse update(UpdatePokemonRequest request, Long id) {
        Pokemon pokemon = find(id);
        pokemon.setName(request.getName());
        pokemon.setSpecies(request.getSpecies());
        pokemon.setType(request.getType());
        pokemon.setImage(request.getName());
        repository.save(pokemon);
        return fromUpdate(pokemon);
    }

    @Override
    public List<GetPokemonResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Pokemon FindOneAndEnsurePicture(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("El pokemon no se encontro"));
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @Override
    public BaseResponse Pokemon(String namePokemon) {
        Pokemon pokemon = repository.Pokemon(namePokemon);
        PokemonResponse response = new PokemonResponse();
        response.setId(pokemon.getId());
        response.setName(pokemon.getName());
        response.setSpecies(pokemon.getSpecies());
        response.setType(pokemon.getType());
        response.setImage(pokemon.getImage());

        return BaseResponse.builder()
                .data(response)
                .message("Pokemon by Name of pokemon")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    public Pokemon to(CreatePokemonRequest request) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(request.getName());
        pokemon.setSpecies(request.getSpecies());
        pokemon.setType(request.getType());
        pokemon.setImage(request.getImage());
        return pokemon;
    }

    public GetPokemonResponse from(Pokemon pokemon) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setId(pokemon.getId());
        response.setType(pokemon.getType());
        response.setSpecies(pokemon.getSpecies());
        response.setName(pokemon.getName());
        response.setImage(pokemon.getImage());
        return response;
    }

    public UpdatePokemonResponse fromUpdate(Pokemon pokemon) {
        UpdatePokemonResponse response = new UpdatePokemonResponse();
        response.setId(pokemon.getId());
        response.setName(pokemon.getName());
        response.setType(pokemon.getType());
        response.setSpecies(pokemon.getSpecies());
        response.setImage(pokemon.getImage());
        return response;
    }
    public Pokemon find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
