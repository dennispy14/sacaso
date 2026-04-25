package com.br.volleyhub.api.controller;

import com.br.volleyhub.api.dto.grupo.GrupoRequest;
import com.br.volleyhub.api.dto.grupo.GrupoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GrupoController {
    ResponseEntity<GrupoResponse> criar(GrupoRequest request);
    ResponseEntity<List<GrupoResponse>> listarPorTorneio(Long torneioId);
    ResponseEntity<GrupoResponse> buscarPorId(Long id);
    ResponseEntity<GrupoResponse> atualizar(Long id, GrupoRequest request);
    ResponseEntity<Void> deletar(Long id);
    ResponseEntity<Void> atualizarTimes(Long id, List<Long> timeIds);
}
