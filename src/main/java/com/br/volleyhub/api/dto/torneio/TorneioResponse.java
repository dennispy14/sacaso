package com.br.volleyhub.api.dto.torneio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.br.volleyhub.api.dto.arena.ArenaResponse;
import com.br.volleyhub.api.dto.time.TimeResponse;

public record TorneioResponse(
                Long id,
                String nome,
                LocalDate startDate,
                LocalDate endDate,
                LocalTime startTime,
                ArenaResponse arena,
                String descricao,
                String status,
                String modalidade,
                String categoria,
                List<TimeResponse> times,
                TournamentConfigDTO config) {
}
