package com.br.sacaso.api.dto.grupo;

import com.br.sacaso.api.dto.time.TimeResponse;
import java.util.List;

public record GrupoResponse(Long id, String nome, Long torneioId, List<TimeResponse> times) {}
