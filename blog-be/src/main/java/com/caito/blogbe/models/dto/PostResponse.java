package com.caito.blogbe.models.dto;

import com.caito.blogbe.models.dto.UserResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private UserResponse user;
    private LocalDateTime created;
    private LocalDateTime updated;
}
