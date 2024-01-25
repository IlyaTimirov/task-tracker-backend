package com.timirov.pet.tasktrackerbackend.advice;

import com.timirov.pet.tasktrackerbackend.exceptions.ErrorResponse;
import com.timirov.pet.tasktrackerbackend.exceptions.PasswordMismatchException;
import com.timirov.pet.tasktrackerbackend.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse resolveHandle(UserAlreadyExistsException e){
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse resolveHandle(PasswordMismatchException e){
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse resolveHandle(BadCredentialsException e){
        return new ErrorResponse("Неверный логин или пароль!", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse resolveHandle(UsernameNotFoundException e){
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
