package com.caito.blogbe.service.impl;

import com.caito.blogbe.constants.ErrorsConstants;
import com.caito.blogbe.entity.Comment;
import com.caito.blogbe.entity.Post;
import com.caito.blogbe.entity.User;
import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.mapper.CommentResponseMapper;
import com.caito.blogbe.models.dto.CommentRequest;
import com.caito.blogbe.models.dto.CommentResponse;
import com.caito.blogbe.repository.CommentRepository;
import com.caito.blogbe.repository.PostRepository;
import com.caito.blogbe.repository.UserRepository;
import com.caito.blogbe.service.contracts.CommentDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService implements CommentDAO {

    @Autowired
    private CommentRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentResponseMapper responseMapper;


    @Override
    @Transactional
    public CommentResponse save(CommentRequest request) throws NotFoundException {
        if (request.getContenet() == null || request.getContenet().isEmpty())
            throw new BadRequestException(ErrorsConstants.CMT_CONT_NULL);
        User user = userRepository.findById(request.getUser_id()).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.USR_NOT_FOUND));
        Post post = postRepository.findById(request.getPost()).orElseThrow(()->
                new NotFoundException(ErrorsConstants.PST_NOT_FOUND));
        Comment comment = new Comment();
        comment.setContent(request.getContenet());
        comment.setUser(user);
        comment.setPost(post);
        repository.save(comment);
        return responseMapper.commentToCommentResponse(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public CommentResponse getById(Long id) throws NotFoundException {

        Comment comment = repository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.CMT_NOT_FOUN));
        return responseMapper.commentToCommentResponse(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponse> getAll() {

        List<Comment> comments = repository.findAll();
        return responseMapper.commentListToCommentResponseList(comments);
    }

    @Override
    public List<CommentResponse> getByPost(Long postId) throws NotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(()->
                new NotFoundException(ErrorsConstants.PST_NOT_FOUND));
        List<Comment> comments = repository.findByPost(post);
        return responseMapper.commentListToCommentResponseList(comments);
    }


    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

        Comment comment = repository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.CMT_NOT_FOUN));
        repository.deleteById(id);
    }
}
