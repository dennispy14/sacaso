package com.br.sacaso.api.controller;

import com.br.sacaso.api.dto.arena.ArenaRequest;
import com.br.sacaso.api.dto.arena.ArenaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/arenas")
public interface ArenaController {

    @GetMapping
    ResponseEntity<List<ArenaResponse>> listar();

    @GetMapping("/{id}")
    ResponseEntity<ArenaResponse> buscarPorId(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ArenaResponse> criar(@RequestBody ArenaRequest request);

    @PutMapping("/{id}")
    ResponseEntity<ArenaResponse> atualizar(@PathVariable Long id, @RequestBody ArenaRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable Long id);
}

