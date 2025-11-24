package com.br.sacaso.api.controller;


import com.br.sacaso.api.dto.fase.FaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/fases")
public interface FaseController {

    @GetMapping
    ResponseEntity<List<FaseResponse>> listar();
}