package com.br.volleyhub.api.dto.partida;

import com.br.volleyhub.domain.enums.StatusPartida;

public record PartidaStatusRequest(
        StatusPartida status
) {}
