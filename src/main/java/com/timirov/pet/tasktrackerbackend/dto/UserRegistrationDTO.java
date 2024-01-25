package com.timirov.pet.tasktrackerbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Parent;

@Data
public class UserRegistrationDTO {

    @NotBlank
    @Parent
    @Email(message = "Некорректо введена почта!")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов!")
    private String password;

    @NotBlank
    private String confirmPassword;
}
