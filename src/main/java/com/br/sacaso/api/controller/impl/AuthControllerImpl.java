package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.AuthController;
import com.br.sacaso.api.dto.auth.AuthResponse;
import com.br.sacaso.api.dto.auth.LoginRequest;
import com.br.sacaso.api.dto.auth.RegisterRequest;
import com.br.sacaso.domain.entity.Usuario;
import com.br.sacaso.domain.repository.UsuarioRepository;
import com.br.sacaso.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<AuthResponse> register(RegisterRequest request) {
        if (repository.existsByUsername(request.username())) {
            return ResponseEntity.badRequest().build();
        }

        Usuario user = Usuario.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        repository.save(user);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole().name()));
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        Usuario user = repository.findByUsername(request.username())
                .orElseThrow();
        
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole().name()));
    }
}
