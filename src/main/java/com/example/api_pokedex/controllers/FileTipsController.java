package com.example.api_pokedex.controllers;

import com.example.api_pokedex.services.interfaces.IFileUpdateTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("file/tips")
public class FileTipsController {
        @Autowired
        private IFileUpdateTipsService service;

        @PutMapping("{idTips}")
        public String upload(@RequestParam MultipartFile file, @PathVariable Long idTips) {
            return service.upload(file,idTips);
        }
    }

