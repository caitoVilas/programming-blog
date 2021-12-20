package com.caito.blogbe.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {

    private Long id;
    private UserResponse user;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
}
