package com.br.sacaso.api.dto.grupo;

import java.util.List;

public record GrupoRequest(String nome, Long torneioId, List<Long> timeIds) {}
