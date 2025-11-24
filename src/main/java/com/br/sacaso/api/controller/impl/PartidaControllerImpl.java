package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.PartidaController;
import com.br.sacaso.api.dto.partida.PartidaRequest;
import com.br.sacaso.api.dto.partida.PartidaResponse;
import com.br.sacaso.api.dto.partida.PartidaStatusRequest;
import com.br.sacaso.domain.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class PartidaControllerImpl implements PartidaController {

    private final PartidaService partidaService;


    @Override
    public ResponseEntity<PartidaResponse> atualizarPlacar(Long id, Integer placarA, Integer placarB) {
        return ResponseEntity.ok(partidaService.atualizarPlacar(id, placarA, placarB));
    }

    @Override
    public ResponseEntity<List<PartidaResponse>> listarPorTorneio(Long torneioId) {
        return null;
    }

    @Override
    public ResponseEntity<PartidaResponse> atualizarStatus(Long id, PartidaStatusRequest request) {
        var response = partidaService.atualizarStatus(id, request.status());
        return ResponseEntity.ok(response);
    }
}
