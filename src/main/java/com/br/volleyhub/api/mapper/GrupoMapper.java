package com.br.volleyhub.api.mapper;

import com.br.volleyhub.api.dto.grupo.GrupoRequest;
import com.br.volleyhub.api.dto.grupo.GrupoResponse;
import com.br.volleyhub.domain.entity.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {TimeMapper.class})
public interface GrupoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "torneio", ignore = true)
    @Mapping(target = "times", ignore = true)
    Grupo toEntity(GrupoRequest request);

    @Mapping(target = "torneioId", source = "torneio.id")
    GrupoResponse toResponse(Grupo entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "torneio", ignore = true)
    @Mapping(target = "times", ignore = true)
    void updateEntityFromRequest(GrupoRequest request, @MappingTarget Grupo entity);
}
