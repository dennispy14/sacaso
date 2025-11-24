package com.br.sacaso.api.dto.partida;

import com.br.sacaso.domain.enums.FaseTorneio;
import com.br.sacaso.domain.enums.StatusPartida;

import java.time.LocalDateTime;

public record PartidaResponse(
        Long id,
        Long torneioId,
        Long timeAId,
        Long timeBId,
        Integer placarA,
        Integer placarB,
        LocalDateTime dataHora,
        FaseTorneio fase,
        String faseDescricao,
        StatusPartida status
) {}
