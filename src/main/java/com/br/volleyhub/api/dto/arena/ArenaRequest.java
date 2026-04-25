package com.br.volleyhub.api.dto.arena;

public record ArenaRequest(
                String nome,
                String local,
                String bairro,
                String cidade,
                String imagemUrl) {
}
