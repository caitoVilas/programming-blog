package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing the data to enter a user")
public class UserNew {

    @ApiModelProperty(name = "username", required = true, example = "caito")
    private String username;
    @ApiModelProperty(name = "email", required = true, example = "caitocd@gmail.com")
    private String email;
    @ApiModelProperty(name = "password", required = true, example = "caito")
    private String password;
    @ApiModelProperty(name = "role", example = "admin")
    private String role;

}
