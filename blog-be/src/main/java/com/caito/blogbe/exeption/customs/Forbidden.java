package com.caito.blogbe.exeption.customs;

public class Forbidden extends RuntimeException{

    Forbidden(String error){
        super(error);
    }
}
