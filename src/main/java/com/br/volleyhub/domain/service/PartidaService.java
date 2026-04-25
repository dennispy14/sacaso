package com.br.volleyhub.domain.service;

import com.br.volleyhub.api.dto.partida.*;
import com.br.volleyhub.domain.enums.StatusPartida;

import java.util.List;

public interface PartidaService {

    PartidaResponse criar(PartidaRequest request);

    List<PartidaResponse> listarPorTorneio(Long torneioId);

    PartidaResponse buscarPorId(Long id);

    PartidaResponse atualizarPlacar(Long id, Integer placarA, Integer placarB);

    PartidaResponse atualizarStatus(Long id, StatusPartida novoStatus);

    void reordenar(List<Long> partidaIds);

}