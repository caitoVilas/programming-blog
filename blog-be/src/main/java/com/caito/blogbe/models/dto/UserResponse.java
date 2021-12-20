package com.caito.blogbe.models.dto;

import com.caito.blogbe.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel(description = "model representing a user for a response")
public class UserResponse {

    @ApiModelProperty(name = "id")
    private Long id;
    @ApiModelProperty(name = "username")
    private String username;
    @ApiModelProperty(name = "email")
    private String email;
    @ApiModelProperty(name = "roles")
    private List<Role> roles;
    @ApiModelProperty(name = "created")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated")
    private LocalDateTime updated;
}
