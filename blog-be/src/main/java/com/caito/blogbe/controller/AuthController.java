package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.UserNew;
import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/v1/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserNew userNew){

        return new ResponseEntity<UserResponse>(authService.save(userNew), HttpStatus.CREATED);
    }
}
