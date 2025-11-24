package com.br.sacaso.api.dto.torneio;

public record TorneioRequest(
        String nome,
        String local,
        String descricao
) {}
