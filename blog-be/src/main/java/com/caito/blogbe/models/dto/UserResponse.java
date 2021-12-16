package com.caito.blogbe.models.dto;

import com.caito.blogbe.entity.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private List<Role> roles;
    private LocalDateTime created;
    private LocalDateTime updated;
}
