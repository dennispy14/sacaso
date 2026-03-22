package com.br.sacaso.api.dto.arena;

public record ArenaResponse(
                Long id,
                String nome,
                String local,
                String bairro,
                String cidade,
                String imagemUrl) {
}
