package com.br.sacaso.api.controller;

import com.br.sacaso.api.dto.partida.PartidaRequest;
import com.br.sacaso.api.dto.partida.PartidaResponse;
import com.br.sacaso.api.dto.partida.PartidaStatusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/partidas")
public interface PartidaController {
    @PatchMapping("/{id}/placar")
    ResponseEntity<PartidaResponse> atualizarPlacar(@PathVariable Long id,
                                                    @RequestParam Integer placarA,
                                                    @RequestParam Integer placarB);

    @GetMapping("/torneio/{torneioId}")
    ResponseEntity<List<PartidaResponse>> listarPorTorneio(Long torneioId);

    @PutMapping("/{id}/status")
    ResponseEntity<PartidaResponse> atualizarStatus(@PathVariable Long id,
                                                    @RequestBody PartidaStatusRequest request);

}
