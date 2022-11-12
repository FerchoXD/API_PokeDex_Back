package com.example.api_pokedex.services.interfaces;

import com.example.api_pokedex.controllers.dtos.request.CreateSkillRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateSkillRequest;
import com.example.api_pokedex.controllers.dtos.response.CreateSkillResponse;
import com.example.api_pokedex.controllers.dtos.response.GetSkillResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateSkillResponse;

import java.util.List;

public interface ISkillService {
    GetSkillResponse get(Long id);

    CreateSkillResponse create(CreateSkillRequest request);

    UpdateSkillResponse update(UpdateSkillRequest request, Long id);

    List<GetSkillResponse> list();

    void delete(Long id);
}
