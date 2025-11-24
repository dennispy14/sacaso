package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.jogador.JogadorRequest;
import com.br.sacaso.api.dto.jogador.JogadorResponse;
import com.br.sacaso.domain.entity.Jogador;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    Jogador toEntity(JogadorRequest request);

    JogadorResponse toResponse(Jogador entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(JogadorRequest request, @MappingTarget Jogador entity);
}
