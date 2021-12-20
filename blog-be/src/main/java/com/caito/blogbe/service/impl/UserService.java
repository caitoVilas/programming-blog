package com.caito.blogbe.service.impl;

import com.caito.blogbe.constants.ErrorsConstants;
import com.caito.blogbe.entity.User;
import com.caito.blogbe.mapper.UserResponseMapper;
import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.repository.UserRepository;
import com.caito.blogbe.service.contracts.UserDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDAO {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserResponseMapper responseMapper;


    @Override
    public UserResponse getById(Long id) throws NotFoundException {

        User user = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorsConstants.USR_NOT_FOUND));

        return responseMapper.userToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAll() throws NotFoundException {
        List<User> users = repository.findAll();
        return responseMapper.userListToUserResponseList(users);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        User user = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorsConstants.USR_NOT_FOUND));
        repository.deleteById(id);
    }
}
