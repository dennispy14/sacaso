package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.FaseController;
import com.br.sacaso.api.dto.fase.FaseResponse;
import com.br.sacaso.domain.service.FaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FaseControllerImpl implements FaseController {

    private final FaseService faseService;

    @Override
    public ResponseEntity<List<FaseResponse>> listar() {
        return ResponseEntity.ok(faseService.listarFases());
    }
}
