package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TorneioMapper {

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "local", source = "location")
    @Mapping(target = "descricao", source = "description")
    Torneio toEntity(TorneioRequest request);

    @Mapping(target = "name", source = "nome")
    @Mapping(target = "location", source = "local")
    @Mapping(target = "description", source = "descricao")
    TorneioResponse toResponse(Torneio entity);

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "local", source = "location")
    @Mapping(target = "descricao", source = "description")
    void updateEntityFromRequest(TorneioRequest request, @MappingTarget Torneio entity);
}
