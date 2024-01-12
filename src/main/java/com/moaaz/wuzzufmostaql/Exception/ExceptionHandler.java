package com.moaaz.wuzzufmostaql.Exception;

import jakarta.validation.ConstraintViolationException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(Exception exception) {
        return exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMailException(MailException mailException) {
        return mailException.getMessage();
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIoException(IOException exception) {
        return exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNoSuchElementException(NoSuchElementException exception){
        return  exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        // Create a custom error response or use a pre-defined ErrorResponse class


        return ResponseEntity.badRequest().body(errors);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = "Email already exists";



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

}
