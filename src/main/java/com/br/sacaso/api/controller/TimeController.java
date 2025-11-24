package com.br.sacaso.api.controller;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/times")
public interface TimeController {

    @PostMapping
    ResponseEntity<TimeResponse> criar(@RequestBody TimeRequest request);

    @GetMapping
    ResponseEntity<List<TimeResponse>> listar();

    @GetMapping("/{id}")
    ResponseEntity<TimeResponse> buscarPorId(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<TimeResponse> atualizar(@PathVariable Long id, @RequestBody TimeRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id);
}
