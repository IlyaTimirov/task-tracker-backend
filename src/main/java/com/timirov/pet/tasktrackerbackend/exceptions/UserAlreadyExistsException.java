package com.timirov.pet.tasktrackerbackend.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("Пользователь с такой почтой уже существует!");
    }
}
