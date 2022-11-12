package com.example.api_pokedex.controllers;

import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.services.interfaces.ITrainersForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trainer-Forum")
public class TrainersForumController {
    @Autowired
    private ITrainersForumService service;

    @GetMapping("trainers/forum/{forumId}")
    public ResponseEntity<BaseResponse> listAllTrainersByForumId(@PathVariable Long forumId){
        BaseResponse baseResponse = service.listAllTrainersByForumId(forumId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }
}
