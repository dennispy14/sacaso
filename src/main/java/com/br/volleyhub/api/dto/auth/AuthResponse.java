package com.br.volleyhub.api.dto.auth;

import java.util.List;

public record AuthResponse(String token, String username, List<String> roles) {}
