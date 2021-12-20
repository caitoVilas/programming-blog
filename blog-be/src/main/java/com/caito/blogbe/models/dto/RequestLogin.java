package com.caito.blogbe.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model that represents the data to enter the system")
public class RequestLogin {

    @ApiModelProperty(name = "email", required = true, example = "caitocd@gmail.com")
    private String email;
    @ApiModelProperty(name = "password", required = true, example = "caito")
    private String password;
}
