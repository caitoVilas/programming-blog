package com.caito.blogbe.exeption.customs;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }
}
