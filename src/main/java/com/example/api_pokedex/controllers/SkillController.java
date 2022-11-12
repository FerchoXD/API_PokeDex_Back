package com.example.api_pokedex.controllers;

import com.example.api_pokedex.controllers.dtos.request.CreateSkillRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateSkillRequest;
import com.example.api_pokedex.controllers.dtos.response.CreateSkillResponse;
import com.example.api_pokedex.controllers.dtos.response.GetSkillResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateSkillResponse;
import com.example.api_pokedex.services.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillServiceImpl service;
    @GetMapping("{id}")
    public GetSkillResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateSkillResponse Create(@RequestBody CreateSkillRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateSkillResponse update(@RequestBody UpdateSkillRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetSkillResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
