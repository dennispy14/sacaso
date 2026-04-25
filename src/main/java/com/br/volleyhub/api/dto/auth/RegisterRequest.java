package com.br.volleyhub.api.dto.auth;

import com.br.volleyhub.domain.enums.Role;
import java.util.Set;

public record RegisterRequest(String username, String email, String password, Set<Role> roles) {}
