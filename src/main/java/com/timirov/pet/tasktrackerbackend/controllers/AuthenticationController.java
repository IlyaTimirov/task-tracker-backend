package com.timirov.pet.tasktrackerbackend.controllers;

import com.timirov.pet.tasktrackerbackend.dto.TokenResponseDTO;
import com.timirov.pet.tasktrackerbackend.dto.UserRequestDTO;
import com.timirov.pet.tasktrackerbackend.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/auth/login")
    public ResponseEntity<TokenResponseDTO> authentication(@RequestBody UserRequestDTO user){
        return ResponseEntity.ok(authenticationService.authentication(user));
    }
}
