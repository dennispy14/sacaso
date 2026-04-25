package com.br.volleyhub.api.dto.grupo;

import com.br.volleyhub.api.dto.time.TimeResponse;
import java.util.List;

public record GrupoResponse(Long id, String nome, Long torneioId, List<TimeResponse> times) {}
