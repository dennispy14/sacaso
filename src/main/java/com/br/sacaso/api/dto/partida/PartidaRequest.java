package com.br.sacaso.api.dto.partida;

import com.br.sacaso.domain.enums.FaseTorneio;
import java.time.LocalDateTime;

public record PartidaRequest(
                Long tournamentId,
                Long teamAId,
                Long teamBId,
                LocalDateTime dateTime,
                FaseTorneio phase) {
}
