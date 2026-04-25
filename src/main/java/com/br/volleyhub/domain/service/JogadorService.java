package com.br.volleyhub.domain.service;

import com.br.volleyhub.api.dto.jogador.JogadorRequest;
import com.br.volleyhub.api.dto.jogador.JogadorResponse;

import java.util.List;

public interface JogadorService {

    JogadorResponse criar(JogadorRequest request);

    List<JogadorResponse> listar();

    JogadorResponse buscarPorId(Long id);

    JogadorResponse atualizar(Long id, JogadorRequest request);

    void deletar(Long id);
}