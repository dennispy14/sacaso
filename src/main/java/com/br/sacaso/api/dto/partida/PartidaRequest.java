package com.br.sacaso.api.dto.partida;

import com.br.sacaso.domain.enums.FaseTorneio;
import java.time.LocalDateTime;

public record PartidaRequest(
        Long torneioId,
        Long timeAId,
        Long timeBId,
        LocalDateTime dataHora,
        FaseTorneio fase
) {}
