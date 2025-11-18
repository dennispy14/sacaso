package com.br.sacaso.controller;

import com.br.sacaso.model.Jogador;
import com.br.sacaso.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> criar(@RequestBody Jogador jogador) {
        return ResponseEntity.ok(jogadorService.salvar(jogador));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> listarTodos() {
        return ResponseEntity.ok(jogadorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}