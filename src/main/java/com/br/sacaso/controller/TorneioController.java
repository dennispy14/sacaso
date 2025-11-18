package com.br.sacaso.controller;

import com.br.sacaso.model.Torneio;
import com.br.sacaso.service.TorneioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneios")
@RequiredArgsConstructor
public class TorneioController {

    private final TorneioService torneioService;

    @PostMapping
    public ResponseEntity<Torneio> criar(@RequestBody Torneio torneio) {
        return ResponseEntity.ok(torneioService.salvar(torneio));
    }

    @GetMapping
    public ResponseEntity<List<Torneio>> listarTodos() {
        return ResponseEntity.ok(torneioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(torneioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneio> atualizar(@PathVariable Long id, @RequestBody Torneio torneioAtualizado) {
        Torneio torneioExistente = torneioService.buscarPorId(id);
        torneioExistente.setNome(torneioAtualizado.getNome());
        return ResponseEntity.ok(torneioService.salvar(torneioExistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        torneioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}