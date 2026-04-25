package com.br.sacaso.api.dto.auth;

import com.br.sacaso.domain.enums.Role;
import java.util.Set;

public record RegisterRequest(String username, String email, String password, Set<Role> roles) {}
