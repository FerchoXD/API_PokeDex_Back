package com.example.api_pokedex.controllers;

import com.example.api_pokedex.services.interfaces.IFileUpdateTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("file")
public class FileController {
        @Autowired
        private IFileUpdateTrainerService service;

        @PutMapping("{idTrainer}")
        public String upload(@RequestParam MultipartFile file,@PathVariable Long idTrainer) {
            return service.upload(file,idTrainer);
        }
}