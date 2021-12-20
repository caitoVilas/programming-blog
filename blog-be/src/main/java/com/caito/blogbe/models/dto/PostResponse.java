package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing the post entity for a response")
public class PostResponse {

    @ApiModelProperty(name = "id")
    private Long id;
    @ApiModelProperty(name = "title")
    private String title;
    @ApiModelProperty(name = "content")
    private String content;
    @ApiModelProperty(name = "user")
    private UserResponse user;
    @ApiModelProperty(name = "created")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated")
    private LocalDateTime updated;
}
