package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.partida.PartidaRequest;
import com.br.sacaso.api.dto.partida.PartidaResponse;
import com.br.sacaso.domain.entity.Partida;
import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.entity.Torneio;
import com.br.sacaso.domain.enums.StatusPartida;
import org.springframework.stereotype.Component;

@Component
public class PartidaMapper {

    public Partida toEntity(PartidaRequest req, Torneio torneio, Time timeA, Time timeB) {
        return Partida.builder()
                .torneio(torneio)
                .timeA(timeA)
                .timeB(timeB)
                .dataHora(req.dataHora())
                .fase(req.fase())
                .status(StatusPartida.AGENDADA)
                .build();
    }

    public PartidaResponse toResponse(Partida partida) {
        return new PartidaResponse(
                partida.getId(),
                partida.getTorneio().getId(),
                partida.getTimeA().getId(),
                partida.getTimeB().getId(),
                partida.getPlacarA(),
                partida.getPlacarB(),
                partida.getDataHora(),
                partida.getFase(),
                partida.getFase().getDescricao(), // <<<<<< aqui
                partida.getStatus()
        );
    }
}
