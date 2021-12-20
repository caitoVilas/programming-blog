package com.caito.blogbe.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentRequest {

    private Long user_id;
    private String contenet;

}
