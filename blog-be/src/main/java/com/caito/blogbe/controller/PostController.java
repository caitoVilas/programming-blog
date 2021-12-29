package com.caito.blogbe.controller;

import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.models.dto.PostRequest;
import com.caito.blogbe.models.dto.PostResponse;
import com.caito.blogbe.service.impl.PostService;
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
@RequestMapping("/api/blog/v1/post")
@CrossOrigin
@Api(value = "collection of methods for handling post")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    @ApiOperation(value = "method for creating post receives a PostRequest and returns a PostResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PostResponse> save(@RequestBody PostRequest request) throws NotFoundException {

        return new ResponseEntity<PostResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that returns a Post receives an id and returns a PostResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PostResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<PostResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that returns a list of posts in PostResponse format")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<PostResponse>> getAll() throws NotFoundException {

        return new ResponseEntity<List<PostResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method that eliminates a post receives an id")
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

    @GetMapping("/search/{text}")
    @ApiOperation(value = "method that looks for posts that meet the criteria returns a list of PostResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<PostResponse>> search(@PathVariable String text) throws BadRequestException {

        return new ResponseEntity<List<PostResponse>>(service.search(text), HttpStatus.OK);
    }
}
