package com.caito.blogbe.models.dto;

import lombok.Data;

@Data
public class UserNew {

    private String username;
    private String email;
    private String password;
    private String role;

}
