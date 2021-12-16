package com.caito.blogbe.models.dto;

import lombok.Data;

@Data
public class RequestLogin {

    private String email;
    private String password;
}
