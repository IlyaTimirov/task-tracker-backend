package com.timirov.pet.tasktrackerbackend.exceptions;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException() {
        super("Пароли не совпадают!");
    }
}
