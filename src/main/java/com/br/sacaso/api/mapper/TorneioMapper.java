package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.arena.ArenaResponse;
import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.Arena;
import com.br.sacaso.domain.entity.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {TimeMapper.class, ArenaMapper.class})
public interface TorneioMapper {

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dataInicio", source = "startDate")
    @Mapping(target = "dataFim", source = "endDate")
    @Mapping(target = "horaInicio", source = "startTime")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "arena", ignore = true)
    Torneio toEntity(TorneioRequest request);

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "startDate", source = "dataInicio")
    @Mapping(target = "endDate", source = "dataFim")
    @Mapping(target = "startTime", source = "horaInicio")
    @Mapping(target = "arena", source = "arena")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "times", source = "times")
    TorneioResponse toResponse(Torneio entity);

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dataInicio", source = "startDate")
    @Mapping(target = "dataFim", source = "endDate")
    @Mapping(target = "horaInicio", source = "startTime")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "arena", ignore = true)
    void updateEntityFromRequest(TorneioRequest request, @MappingTarget Torneio entity);
}
