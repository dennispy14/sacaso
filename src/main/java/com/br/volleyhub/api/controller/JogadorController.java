package com.br.volleyhub.api.controller;


import com.br.volleyhub.api.dto.jogador.JogadorRequest;
import com.br.volleyhub.api.dto.jogador.JogadorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/players")
public interface JogadorController {
    @PostMapping
    ResponseEntity<JogadorResponse> criar(@RequestBody JogadorRequest request);

    @GetMapping
    ResponseEntity<List<JogadorResponse>> listar();

    @GetMapping("/{id}")
    ResponseEntity<JogadorResponse> buscarPorId(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<JogadorResponse> atualizar(
            @PathVariable Long id,
            @RequestBody JogadorRequest request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id);
}
