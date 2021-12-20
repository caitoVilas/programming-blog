package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.CommentRequest;
import com.caito.blogbe.models.dto.CommentResponse;
import com.caito.blogbe.service.impl.CommentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public ResponseEntity<CommentResponse> save(@RequestBody CommentRequest request) throws NotFoundException {

        return new ResponseEntity<CommentResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<CommentResponse>(service.getById(id), HttpStatus.MULTI_STATUS);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAll(){

        return new ResponseEntity<List<CommentResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
