package com.br.sacaso.api.controller;

import com.br.sacaso.domain.entity.Fase;
import com.br.sacaso.domain.service.FaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fases")
@RequiredArgsConstructor
public class FaseController {

    private final FaseService faseService;

    @PostMapping
    public ResponseEntity<Fase> criar(@RequestBody Fase fase) {
        return ResponseEntity.ok(faseService.salvar(fase));
    }

    @GetMapping
    public ResponseEntity<List<Fase>> listarTodas() {
        return ResponseEntity.ok(faseService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fase> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(faseService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        faseService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}