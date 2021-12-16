package com.caito.blogbe.controller;

import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.service.impl.UserService;
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
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<UserResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseEntity>> getAll() throws NotFoundException {

        return new ResponseEntity<List<ResponseEntity>>((MultiValueMap<String, String>) service.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
