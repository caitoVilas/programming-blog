package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing the data for entering a comment")
public class CommentRequest {

    @ApiModelProperty(name = "user_id", required = true, example = "1")
    private Long user_id;
    @ApiModelProperty(name = "content", required = true, example = "comentario sobre el post")
    private String contenet;
    @ApiModelProperty(name = "post_id", required = true, example = "1")
    private Long post;

}
