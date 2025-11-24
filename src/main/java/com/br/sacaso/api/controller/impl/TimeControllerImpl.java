package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.TimeController;
import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import com.br.sacaso.domain.service.impl.TimeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimeControllerImpl implements TimeController {

    private final TimeServiceImpl timeService;

    @Override
    public ResponseEntity<TimeResponse> criar(TimeRequest request) {
        return ResponseEntity.ok(timeService.criar(request));
    }

    @Override
    public ResponseEntity<List<TimeResponse>> listar() {
        return ResponseEntity.ok(timeService.listar());
    }

    @Override
    public ResponseEntity<TimeResponse> buscarPorId(Long id) {
        return ResponseEntity.ok(timeService.buscarPorId(id));
    }

    @Override
    public ResponseEntity<TimeResponse> atualizar(Long id, TimeRequest request) {
        return ResponseEntity.ok(timeService.atualizar(id, request));
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        timeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
