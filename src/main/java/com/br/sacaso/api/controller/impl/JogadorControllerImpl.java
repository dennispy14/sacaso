package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.JogadorController;
import com.br.sacaso.api.dto.jogador.JogadorRequest;
import com.br.sacaso.api.dto.jogador.JogadorResponse;
import com.br.sacaso.domain.service.impl.JogadorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JogadorControllerImpl implements JogadorController {

    private final JogadorServiceImpl jogadorService;

    @Override
    public ResponseEntity<JogadorResponse> criar(JogadorRequest request) {
        return ResponseEntity.ok(jogadorService.criar(request));
    }

    @Override
    public ResponseEntity<List<JogadorResponse>> listar() {
        return ResponseEntity.ok(jogadorService.listar());
    }

    @Override
    public ResponseEntity<JogadorResponse> buscarPorId(Long id) {
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }

    @Override
    public ResponseEntity<JogadorResponse> atualizar(Long id, JogadorRequest request) {
        return ResponseEntity.ok(jogadorService.atualizar(id, request));
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}