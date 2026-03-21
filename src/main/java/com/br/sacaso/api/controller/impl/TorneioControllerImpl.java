package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.TorneioController;
import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.service.impl.TorneioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TorneioControllerImpl implements TorneioController {

    private final TorneioServiceImpl torneioService;

    @Override
    public ResponseEntity<TorneioResponse> criar(TorneioRequest request) {
        return ResponseEntity.ok(torneioService.criar(request));
    }

    @Override
    public ResponseEntity<List<TorneioResponse>> listar() {
        return ResponseEntity.ok(torneioService.listar());
    }

    @Override
    public ResponseEntity<TorneioResponse> buscarPorId(Long id) {
        return ResponseEntity.ok(torneioService.buscarPorId(id));
    }

    @Override
    public ResponseEntity<TorneioResponse> atualizar(Long id, TorneioRequest request) {
        return ResponseEntity.ok(torneioService.atualizar(id, request));
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        torneioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> vincularTime(Long torneioId, Long timeId) {
        torneioService.vincularTime(torneioId, timeId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> desvincularTime(Long torneioId, Long timeId) {
        torneioService.desvincularTime(torneioId, timeId);
        return ResponseEntity.noContent().build();
    }
}
