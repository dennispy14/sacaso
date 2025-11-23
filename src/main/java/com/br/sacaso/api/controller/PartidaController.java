package com.br.sacaso.api.controller;

import com.br.sacaso.domain.entity.Partida;
import com.br.sacaso.domain.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;

    @PostMapping
    public ResponseEntity<Partida> criar(@RequestBody Partida partida) {
        return ResponseEntity.ok(partidaService.salvar(partida));
    }

    @GetMapping
    public ResponseEntity<List<Partida>> listarTodas() {
        return ResponseEntity.ok(partidaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(partidaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        partidaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}