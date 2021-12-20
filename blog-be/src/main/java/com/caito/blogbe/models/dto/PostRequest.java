package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing the post entity for an income")
public class PostRequest {

    @ApiModelProperty(value = "title", required = true, example = "titulo")
    private String title;
    @ApiModelProperty(value = "content", required = true, example = "contenido del post")
    private String content;
    @ApiModelProperty(value = "user_id", required = true, example = "1")
    private Long user_id;
}
