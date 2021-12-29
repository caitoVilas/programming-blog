package com.caito.blogbe.mapper;

import com.caito.blogbe.entity.Post;
import com.caito.blogbe.models.dto.PostResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostResponseMapper {

    PostResponse postToPostResponse(Post post);
    List<PostResponse> postListToPostResponseList(List<Post> posts);
}
