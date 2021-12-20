package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1/user")
@CrossOrigin
@Api(value = "collection of methods for handling users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "method that returns a user receives an id and returns a UserResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<UserResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that returns a list of users in UserResponse format")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<UserResponse>> getAll() throws NotFoundException {

        return new ResponseEntity<List<UserResponse>>(service.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method that removes a user receives an id")
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
