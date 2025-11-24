package com.br.sacaso.domain.service;

import com.br.sacaso.api.dto.partida.*;
import com.br.sacaso.domain.enums.StatusPartida;

import java.util.List;

public interface PartidaService {

    PartidaResponse criar(PartidaRequest request);

    List<PartidaResponse> listarPorTorneio(Long torneioId);

    PartidaResponse buscarPorId(Long id);

    PartidaResponse atualizarPlacar(Long id, Integer placarA, Integer placarB);

    PartidaResponse atualizarStatus(Long id, StatusPartida novoStatus);

}