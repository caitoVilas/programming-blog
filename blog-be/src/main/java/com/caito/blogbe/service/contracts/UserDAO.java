package com.caito.blogbe.service.contracts;

import com.caito.blogbe.models.dto.UserResponse;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    UserResponse getById(Long id) throws NotFoundException;
    List<UserResponse> getAll() throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
