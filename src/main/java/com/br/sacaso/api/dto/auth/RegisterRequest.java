package com.br.sacaso.api.dto.auth;

import com.br.sacaso.domain.enums.Role;

public record RegisterRequest(String username, String email, String password, Role role) {}
