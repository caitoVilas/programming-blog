package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.PostRequest;
import com.caito.blogbe.models.dto.PostResponse;
import com.caito.blogbe.service.impl.PostService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1/post")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody PostRequest request) throws NotFoundException {

        return new ResponseEntity<PostResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<PostResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAll() throws NotFoundException {

        return new ResponseEntity<List<PostResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
