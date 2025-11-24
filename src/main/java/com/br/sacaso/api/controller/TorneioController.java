package com.br.sacaso.api.controller;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/torneios")
public interface TorneioController {

    @PostMapping
    ResponseEntity<TorneioResponse> criar(@RequestBody TorneioRequest request);

    @GetMapping
    ResponseEntity<List<TorneioResponse>> listar();

    @GetMapping("/{id}")
    ResponseEntity<TorneioResponse> buscarPorId(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<TorneioResponse> atualizar(@PathVariable Long id, @RequestBody TorneioRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id);
}
