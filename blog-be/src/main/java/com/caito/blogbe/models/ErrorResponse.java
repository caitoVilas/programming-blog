package com.caito.blogbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private Integer status;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}
