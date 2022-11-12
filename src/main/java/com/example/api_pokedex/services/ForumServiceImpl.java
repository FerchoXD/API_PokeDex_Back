package com.example.api_pokedex.services;

import com.example.api_pokedex.controllers.dtos.request.CreateForumRequest;
import com.example.api_pokedex.controllers.dtos.request.UpdateForumRequest;
import com.example.api_pokedex.controllers.dtos.response.BaseResponse;
import com.example.api_pokedex.controllers.dtos.response.GetForumResponse;
import com.example.api_pokedex.controllers.dtos.response.UpdateForumResponse;
import com.example.api_pokedex.entities.Forum;
import com.example.api_pokedex.repositories.IForumRepository;
import com.example.api_pokedex.services.interfaces.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements IForumService {
    @Autowired
    private IForumRepository repository;

    @Override
    public GetForumResponse get(Long id) {
        Forum forum = find(id);
        return from(forum);
    }

    @Override
    public BaseResponse create(CreateForumRequest request) {
        Forum forum = to(request);
        return BaseResponse.builder()
                .data(from(repository.save(forum)))
                .message("Forum Created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public List<GetForumResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UpdateForumResponse update(UpdateForumRequest request, Long id) {
        Forum forum = find(id);
        forum.setTopic(request.getTopic());
        forum.setDate(request.getDate());
        forum.setHour(request.getHour());
        repository.save(forum);
        return fromUpdate(forum);
    }


    public GetForumResponse from(Forum forum) {
        GetForumResponse response = new GetForumResponse();
        response.setId(forum.getId());
        response.setTopic(forum.getTopic());
        response.setHour(forum.getHour());
        response.setDate(forum.getDate());
        return response;
    }

    private Forum to(CreateForumRequest request) {
        Forum forum = new Forum();
        forum.setTopic(request.getTopic());
        forum.setDate(request.getDate());
        forum.setHour(request.getHour());
        return forum;
    }

    public UpdateForumResponse fromUpdate(Forum forum) {
        UpdateForumResponse response = new UpdateForumResponse();
        response.setId(forum.getId());
        response.setTopic(forum.getTopic());
        response.setHour(forum.getHour());
        response.setDate(forum.getDate());
        return response;
    }

    public Forum save(Forum forum) {
        return repository.save(forum);
    }

    public Forum find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
