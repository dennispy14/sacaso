package com.br.volleyhub.api.dto.arena;

public record ArenaResponse(
                Long id,
                String nome,
                String local,
                String bairro,
                String cidade,
                String imagemUrl) {
}
