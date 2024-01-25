package com.timirov.pet.tasktrackerbackend.services;

import com.timirov.pet.tasktrackerbackend.dto.TokenResponseDTO;
import com.timirov.pet.tasktrackerbackend.dto.UserRegistrationDTO;
import com.timirov.pet.tasktrackerbackend.dto.UserRequestDTO;
import com.timirov.pet.tasktrackerbackend.entities.User;
import com.timirov.pet.tasktrackerbackend.exceptions.PasswordMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;

    private final AuthenticationService authenticationService;


    public TokenResponseDTO registration(UserRegistrationDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new PasswordMismatchException();
        }
        userService.create(User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build());
        return authenticationService.authentication(new UserRequestDTO(userDTO.getEmail(), userDTO.getPassword()));
    }
}
