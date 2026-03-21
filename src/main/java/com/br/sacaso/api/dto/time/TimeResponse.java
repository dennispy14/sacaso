package com.br.sacaso.api.dto.time;

import com.br.sacaso.api.dto.jogador.JogadorResponse;
import java.util.List;

public record TimeResponse(
                Long id,
                String name,
                String category,
                List<JogadorResponse> jogadores) {
}
