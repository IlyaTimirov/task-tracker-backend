package com.timirov.pet.tasktrackerbackend.controllers;

import com.timirov.pet.tasktrackerbackend.dto.TokenResponseDTO;
import com.timirov.pet.tasktrackerbackend.dto.UserRegistrationDTO;
import com.timirov.pet.tasktrackerbackend.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<TokenResponseDTO> registration(@RequestBody UserRegistrationDTO user){
        return ResponseEntity.ok(registrationService.registration(user));
    }
}
