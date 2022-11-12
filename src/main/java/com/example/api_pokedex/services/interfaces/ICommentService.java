package com.example.api_pokedex.services.interfaces;

import com.example.api_pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetCommentResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateCommentResponse;

import java.util.List;

public interface ICommentService {
    GetCommentResponse get(Long id);

    BaseResponse create(CreateCommentRequest request);

    UpdateCommentResponse update(UpdateCommentRequest request, Long id);

    List<GetCommentResponse> list();

    void delete(Long id);
}
