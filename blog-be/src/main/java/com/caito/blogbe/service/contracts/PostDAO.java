package com.caito.blogbe.service.contracts;

import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.models.dto.PostRequest;
import com.caito.blogbe.models.dto.PostResponse;
import javassist.NotFoundException;

import java.util.List;

public interface PostDAO {

    PostResponse save(PostRequest request) throws NotFoundException;
    PostResponse getById(Long id) throws NotFoundException;
    List<PostResponse> getAll() throws NotFoundException;
    List<PostResponse> search(String text) throws BadRequestException;
    void delete(long id) throws NotFoundException;
}
