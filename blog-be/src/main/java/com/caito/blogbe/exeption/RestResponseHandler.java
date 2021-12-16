package com.caito.blogbe.exeption;

import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.exeption.customs.EmptyImputException;
import com.caito.blogbe.exeption.customs.Forbidden;
import com.caito.blogbe.models.ErrorResponse;
import javassist.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> notFoundException(Exception e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(404, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            DuplicateKeyException.class,
            MethodArgumentTypeMismatchException.class,
            EmptyImputException.class
    })
    protected ResponseEntity<?> badRequestException(Exception e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(400, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Forbidden.class)
    protected ResponseEntity<?> forbidden(Exception e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(403, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<?> conflictException(Exception e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(409, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(errorResponse, HttpStatus.CONFLICT);
    }
}
