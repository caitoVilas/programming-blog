package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.UserNew;
import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.service.impl.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/v1/auth")
@CrossOrigin
@Api
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    @ApiOperation(value = "method to create users into the system")
    @ApiResponses({
            @ApiResponse(code = 201, message = "user created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<UserResponse> save(@RequestBody UserNew userNew){

        return new ResponseEntity<UserResponse>(authService.save(userNew), HttpStatus.CREATED);
    }
}
