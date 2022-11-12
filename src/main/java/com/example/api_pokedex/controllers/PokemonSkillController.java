package com.example.api_pokedex.controllers;

import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.services.PokemonSkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon-skill")
public class PokemonSkillController {
    @Autowired
    private PokemonSkillServiceImpl service;

    @GetMapping("pokemon/skill/{pokemonId}")
    public ResponseEntity<BaseResponse> listAllSkillsByPokemonId(@PathVariable Long pokemonId){
        BaseResponse baseResponse = service.listAllSkillsByPokemonId(pokemonId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping("skill/pokemon/{skillId}")
    public ResponseEntity<BaseResponse> listAllPokemonBySkillsId(@PathVariable Long skillId){
        BaseResponse baseResponse = service.listAllPokemonBySkillsId(skillId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }
}
