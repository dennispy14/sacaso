package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {TimeMapper.class, ArenaMapper.class})
public interface TorneioMapper {

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dataInicio", source = "startDate")
    @Mapping(target = "dataFim", source = "endDate")
    @Mapping(target = "horaInicio", source = "startTime")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "arena", ignore = true)
    @Mapping(target = "config", source = "config")
    Torneio toEntity(TorneioRequest request);

    @Mapping(target = "id", ignore = true)
    TournamentConfig toEntity(com.br.sacaso.api.dto.torneio.TournamentConfigDTO dto);

    @Mapping(target = "id", ignore = true)
    GameRules toEntity(com.br.sacaso.api.dto.torneio.TournamentConfigDTO.GameRulesDTO dto);

    @Mapping(target = "id", ignore = true)
    TournamentPhase toEntity(com.br.sacaso.api.dto.torneio.TournamentConfigDTO.TournamentPhaseDTO dto);

    @Mapping(target = "id", ignore = true)
    GroupConfig toEntity(com.br.sacaso.api.dto.torneio.TournamentConfigDTO.GroupConfigDTO dto);

    @Mapping(target = "id", ignore = true)
    SeriesConfig toEntity(com.br.sacaso.api.dto.torneio.TournamentConfigDTO.SeriesConfigDTO dto);

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "startDate", source = "dataInicio")
    @Mapping(target = "endDate", source = "dataFim")
    @Mapping(target = "startTime", source = "horaInicio")
    @Mapping(target = "arena", source = "arena")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "times", source = "times")
    @Mapping(target = "config", source = "config")
    TorneioResponse toResponse(Torneio entity);

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dataInicio", source = "startDate")
    @Mapping(target = "dataFim", source = "endDate")
    @Mapping(target = "horaInicio", source = "startTime")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "arena", ignore = true)
    @Mapping(target = "config", source = "config")
    void updateEntityFromRequest(TorneioRequest request, @MappingTarget Torneio entity);
}
