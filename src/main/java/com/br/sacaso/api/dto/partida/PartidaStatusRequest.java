package com.br.sacaso.api.dto.partida;

import com.br.sacaso.domain.enums.StatusPartida;

public record PartidaStatusRequest(
        StatusPartida status
) {}
