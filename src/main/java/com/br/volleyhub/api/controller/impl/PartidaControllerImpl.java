package com.br.volleyhub.api.controller.impl;

import com.br.volleyhub.api.controller.PartidaController;
import com.br.volleyhub.api.dto.partida.PartidaResponse;
import com.br.volleyhub.api.dto.partida.PartidaStatusRequest;
import com.br.volleyhub.domain.service.PartidaService;
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
        return ResponseEntity.ok(partidaService.listarPorTorneio(torneioId));
    }

    @Override
    public ResponseEntity<PartidaResponse> atualizarStatus(Long id, PartidaStatusRequest request) {
        var response = partidaService.atualizarStatus(id, request.status());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> reordenar(List<Long> partidaIds) {
        partidaService.reordenar(partidaIds);
        return ResponseEntity.ok().build();
    }
}
