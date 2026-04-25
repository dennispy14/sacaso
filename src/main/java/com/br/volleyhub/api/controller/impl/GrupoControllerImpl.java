package com.br.volleyhub.api.controller.impl;

import com.br.volleyhub.api.controller.GrupoController;
import com.br.volleyhub.api.dto.grupo.GrupoRequest;
import com.br.volleyhub.api.dto.grupo.GrupoResponse;
import com.br.volleyhub.domain.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GrupoControllerImpl implements GrupoController {

    private final GrupoService service;

    @Override
    @PostMapping
    public ResponseEntity<GrupoResponse> criar(@RequestBody GrupoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @GetMapping("/torneio/{torneioId}")
    public ResponseEntity<List<GrupoResponse>> listarPorTorneio(@PathVariable Long torneioId) {
        return ResponseEntity.ok(service.listarPorTorneio(torneioId));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GrupoResponse> atualizar(@PathVariable Long id, @RequestBody GrupoRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}/times")
    public ResponseEntity<Void> atualizarTimes(@PathVariable Long id, @RequestBody List<Long> timeIds) {
        service.atualizarTimes(id, timeIds);
        return ResponseEntity.noContent().build();
    }
}
