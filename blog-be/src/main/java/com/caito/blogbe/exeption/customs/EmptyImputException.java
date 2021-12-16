package com.caito.blogbe.exeption.customs;

public class EmptyImputException extends RuntimeException{

    EmptyImputException(String error){
        super(error);
    }
}
