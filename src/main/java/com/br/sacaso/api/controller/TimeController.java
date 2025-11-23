package com.br.sacaso.api.controller;

import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/times")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping
    public ResponseEntity<Time> criar(@RequestBody Time time) {
        return ResponseEntity.ok(timeService.salvar(time));
    }

    @GetMapping
    public ResponseEntity<List<Time>> listarTodos() {
        return ResponseEntity.ok(timeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(timeService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        timeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}