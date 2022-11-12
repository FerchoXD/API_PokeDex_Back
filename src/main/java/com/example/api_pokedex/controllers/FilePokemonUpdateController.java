package com.example.api_pokedex.controllers;

import com.example.api_pokedex.services.interfaces.IFileUpdatePokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file/pokemon")
public class FilePokemonUpdateController {
    @Autowired
    private IFileUpdatePokemonService service;

    @PutMapping("{idPokemon}")
    public String upload(@RequestParam MultipartFile file, @PathVariable Long idPokemon) {
        return service.upload(file,idPokemon);
    }
}
