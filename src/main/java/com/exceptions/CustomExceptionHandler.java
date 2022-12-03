package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<Object> handleHeaderException(Exception exception, WebRequest request) {
        List<String> details = new ArrayList<String>();

        details.add(exception.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("OOPS! Header missing...", details);

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectedException(Exception exception, WebRequest request) {
        List<String> details = new ArrayList<String>();

        details.add(exception.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("OOPS! Something went wrong...", details);

        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
