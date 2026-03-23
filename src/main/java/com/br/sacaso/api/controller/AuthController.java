package com.br.sacaso.api.controller;

import com.br.sacaso.api.dto.auth.AuthResponse;
import com.br.sacaso.api.dto.auth.LoginRequest;
import com.br.sacaso.api.dto.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthController {

    @PostMapping("/register")
    ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request);

    @PostMapping("/login")
    ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request);
}
