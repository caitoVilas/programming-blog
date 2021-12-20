package com.caito.blogbe.models.dto;

import lombok.Data;

@Data
public class PostRequest {

    private String title;
    private String content;
    private Long user_id;
}
