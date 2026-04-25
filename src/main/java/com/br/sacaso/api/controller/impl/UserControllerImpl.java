package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.UserController;
import com.br.sacaso.domain.entity.Usuario;
import com.br.sacaso.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<List<String>> getAvailableProfiles() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<String> availableRoles = usuario.getRoles().stream()
                .map(Enum::name)
                .toList();

        return ResponseEntity.ok(availableRoles);
    }
}
