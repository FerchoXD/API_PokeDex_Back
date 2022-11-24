package com.example.api_pokedex.controllers;

import com.example.api_pokedex.controllers.dtos.request.CreatePokemonRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdatePokemonRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetPokemonResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdatePokemonResponse;
import com.example.api_pokedex.services.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    private PokemonServiceImpl service;
    @GetMapping("{id}")
    public GetPokemonResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody CreatePokemonRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public UpdatePokemonResponse update(@RequestBody UpdatePokemonRequest request,@PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping("search/{namePokemon}")
    public ResponseEntity<BaseResponse> Pokemon(@PathVariable String namePokemon){
        BaseResponse baseResponse = service.Pokemon(namePokemon);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping
    public List<GetPokemonResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
