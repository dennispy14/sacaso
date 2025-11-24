package com.br.sacaso.api.dto.torneio;

public record TorneioResponse(
        Long id,
        String nome,
        String local,
        String descricao
) {}
