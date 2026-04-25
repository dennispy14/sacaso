package com.br.volleyhub.api.dto.grupo;

import java.util.List;

public record GrupoRequest(String nome, Long torneioId, List<Long> timeIds) {}
