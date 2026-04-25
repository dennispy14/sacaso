package com.br.volleyhub.api.dto.jogador;

public record JogadorResponse(
                Long id,
                String name,
                Integer age,
                String gender,
                String position,
                String status,
                String team,
                String imageUrl) {
}
