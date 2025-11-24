package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TorneioMapper {

    Torneio toEntity(TorneioRequest request);

    TorneioResponse toResponse(Torneio entity);

    void updateEntityFromRequest(TorneioRequest request, @MappingTarget Torneio entity);
}
