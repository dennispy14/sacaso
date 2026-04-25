package com.br.volleyhub.api.controller.impl;

import com.br.volleyhub.api.controller.AuthController;
import com.br.volleyhub.api.dto.auth.AuthResponse;
import com.br.volleyhub.api.dto.auth.LoginRequest;
import com.br.volleyhub.api.dto.auth.RegisterRequest;
import com.br.volleyhub.domain.entity.Usuario;
import com.br.volleyhub.domain.repository.UsuarioRepository;
import com.br.volleyhub.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import com.br.volleyhub.domain.enums.Role;
import java.util.Set;

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
                .roles(request.roles() != null && !request.roles().isEmpty() ? request.roles() : Set.of(Role.ESPECTADOR))
                .build();

        repository.save(user);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRoles().stream().map(Enum::name).toList()));
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        Usuario user = repository.findByUsername(request.username())
                .orElseThrow();
        
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRoles().stream().map(Enum::name).toList()));
    }
}
