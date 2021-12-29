package com.caito.blogbe.service.impl;

import com.caito.blogbe.constants.ErrorsConstants;
import com.caito.blogbe.entity.Post;
import com.caito.blogbe.entity.User;
import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.mapper.PostResponseMapper;
import com.caito.blogbe.models.dto.PostRequest;
import com.caito.blogbe.models.dto.PostResponse;
import com.caito.blogbe.repository.PostRepository;
import com.caito.blogbe.repository.UserRepository;
import com.caito.blogbe.service.contracts.PostDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService implements PostDAO {

    @Autowired
    private PostRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostResponseMapper responseMapper;


    @Override
    @Transactional
    public PostResponse save(PostRequest request) throws NotFoundException {

        if (request.getTitle() == null || request.getTitle().isEmpty())
            throw new BadRequestException(ErrorsConstants.PST_TITLE_NULL);
        if ((request.getContent() == null || request.getContent().isEmpty()))
            throw new BadRequestException(ErrorsConstants.PST_CONT_NULL);
        User user = userRepository.findById(request.getUser_id()).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.USR_NOT_FOUND));
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setUser(user);
        repository.save(post);
        return responseMapper.postToPostResponse(post);
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponse getById(Long id) throws NotFoundException {

        Post post = repository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.PST_NOT_FOUND));
        return responseMapper.postToPostResponse(post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> getAll() throws NotFoundException {
        List<Post> posts = repository.findAll();

        return responseMapper.postListToPostResponseList(posts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> search(String text) throws BadRequestException {
        if (text == null || text.isEmpty())
            throw new BadRequestException(ErrorsConstants.PST_SEARCH_EMPTY);
        List<Post> posts = repository.findByTitleContaining(text);
        return responseMapper.postListToPostResponseList(posts);
    }

    @Override
    @Transactional
    public void delete(long id) throws NotFoundException {
        Post post = repository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorsConstants.PST_NOT_FOUND));
        repository.deleteById(id);
    }
}
