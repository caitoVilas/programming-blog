package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing the comment entity in a reply")
public class CommentResponse {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "user")
    private UserResponse user;
    @ApiModelProperty(value = "content")
    private String content;
    @ApiModelProperty(name = "post")
    private PostResponse post;
    @ApiModelProperty(value = "created")
    private LocalDateTime created;
    @ApiModelProperty(value = "updated")
    private LocalDateTime updated;
}
