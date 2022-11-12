package com.example.api_pokedex.controllers;


import com.example.api_pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetCommentResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateCommentResponse;
import com.example.api_pokedex.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService service;

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody @Valid CreateCommentRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public UpdateCommentResponse update(@RequestBody UpdateCommentRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetCommentResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
