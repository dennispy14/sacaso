package com.br.sacaso.api.dto.partida;

import com.br.sacaso.domain.enums.FaseTorneio;
import com.br.sacaso.domain.enums.StatusPartida;

import java.time.LocalDateTime;

public record PartidaResponse(
                Long id,
                Long tournamentId,
                Long teamAId,
                Long teamBId,
                Integer scoreA,
                Integer scoreB,
                LocalDateTime dateTime,
                FaseTorneio phase,
                String phaseDescription,
                StatusPartida status) {
}
