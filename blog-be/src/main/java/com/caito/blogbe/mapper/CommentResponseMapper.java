package com.caito.blogbe.mapper;

import com.caito.blogbe.entity.Comment;
import com.caito.blogbe.models.dto.CommentResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {

    CommentResponse commentToCommentResponse(Comment comment);
    List<CommentResponse> commentListToCommentResponseList(List<Comment> comments);
}
