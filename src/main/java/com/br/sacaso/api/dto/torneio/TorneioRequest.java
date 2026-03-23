package com.br.sacaso.api.dto.torneio;

import java.time.LocalDate;
import java.time.LocalTime;


public record TorneioRequest(
                String nome,
                LocalDate startDate,
                LocalDate endDate,
                LocalTime startTime,
                Long arenaId,
                String descricao,
                String status,
                String modalidade,
                String categoria,
                TournamentConfigDTO config) {
}
