package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.CommentRequest;
import com.caito.blogbe.models.dto.CommentResponse;
import com.caito.blogbe.service.impl.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1/comment")
@CrossOrigin
@Api(value = "collection of methods for handling comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    @ApiOperation(value =
            "creating a comment on a post receives a CommentRequest and returns a CommentResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<CommentResponse> save(@RequestBody CommentRequest request) throws NotFoundException {

        return new ResponseEntity<CommentResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that returns a comment receives the id and returns a CommentResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<CommentResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<CommentResponse>(service.getById(id), HttpStatus.MULTI_STATUS);
    }

    @GetMapping
    @ApiOperation(value = "method that returns a list of CommentResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<CommentResponse>> getAll(){

        return new ResponseEntity<List<CommentResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method that removes a comment receives the id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
