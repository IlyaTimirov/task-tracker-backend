package com.timirov.pet.tasktrackerbackend.services;

import com.timirov.pet.tasktrackerbackend.dto.TokenResponseDTO;
import com.timirov.pet.tasktrackerbackend.dto.UserRequestDTO;
import com.timirov.pet.tasktrackerbackend.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomUserDetailsService customUserDetailsService;

    private final JwtTokenUtils jwtTokenUtils;

    private final AuthenticationManager authenticationManager;
    public TokenResponseDTO authentication(UserRequestDTO user) throws BadCredentialsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
        String token = jwtTokenUtils.generateToken(userDetails);
        return new TokenResponseDTO(token);
    }

}
