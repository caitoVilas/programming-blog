package com.caito.blogbe.service.contracts;

import com.caito.blogbe.models.dto.CommentRequest;
import com.caito.blogbe.models.dto.CommentResponse;
import javassist.NotFoundException;

import java.util.List;

public interface CommentDAO {

    CommentResponse save(CommentRequest request) throws NotFoundException;
    CommentResponse getById(Long id) throws NotFoundException;
    List<CommentResponse> getAll();
    List<CommentResponse> getByPost(Long postId) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
