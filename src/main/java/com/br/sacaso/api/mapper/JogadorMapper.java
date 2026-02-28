package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.jogador.JogadorRequest;
import com.br.sacaso.api.dto.jogador.JogadorResponse;
import com.br.sacaso.domain.entity.Jogador;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "idade", source = "age")
    Jogador toEntity(JogadorRequest request);

    @Mapping(target = "name", source = "nome")
    @Mapping(target = "age", source = "idade")
    JogadorResponse toResponse(Jogador entity);

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "idade", source = "age")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(JogadorRequest request, @MappingTarget Jogador entity);
}
