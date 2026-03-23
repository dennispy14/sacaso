package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.grupo.GrupoRequest;
import com.br.sacaso.api.dto.grupo.GrupoResponse;
import com.br.sacaso.domain.entity.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {TimeMapper.class})
public interface GrupoMapper {

    @Mapping(target = "torneio", ignore = true)
    @Mapping(target = "times", ignore = true)
    Grupo toEntity(GrupoRequest request);

    @Mapping(target = "torneioId", source = "torneio.id")
    GrupoResponse toResponse(Grupo entity);

    @Mapping(target = "torneio", ignore = true)
    @Mapping(target = "times", ignore = true)
    void updateEntityFromRequest(GrupoRequest request, @MappingTarget Grupo entity);
}
