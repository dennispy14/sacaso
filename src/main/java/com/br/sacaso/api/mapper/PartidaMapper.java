package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.partida.PartidaRequest;
import com.br.sacaso.api.dto.partida.PartidaResponse;
import com.br.sacaso.api.dto.partida.PartidaResultadoRequest;
import com.br.sacaso.domain.entity.Partida;
import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.entity.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PartidaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true) // será definido no service
    @Mapping(target = "torneio", source = "torneio")
    @Mapping(target = "timeA", source = "timeA")
    @Mapping(target = "timeB", source = "timeB")
    @Mapping(target = "dataHora", expression = "java(java.time.LocalDateTime.now())")
    Partida toEntity(PartidaRequest request, Torneio torneio, Time timeA, Time timeB);

    // MapStruct resolve automaticamente os getters
    @Mapping(target = "torneioId", source = "torneio.id")
    @Mapping(target = "timeAId", source = "timeA.id")
    @Mapping(target = "timeBId", source = "timeB.id")
    PartidaResponse toResponse(Partida partida);

    @Mapping(target = "status", ignore = true)
    void updateResultadoFromRequest(PartidaResultadoRequest request, @MappingTarget Partida entity);
}
