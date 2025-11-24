package com.br.sacaso.domain.service;

import com.br.sacaso.api.dto.request.JogadorRequest;
import com.br.sacaso.api.dto.response.JogadorResponse;

import java.util.List;

public interface JogadorService {

    JogadorResponse criar(JogadorRequest request);

    List<JogadorResponse> listar();

    JogadorResponse buscarPorId(Long id);

    JogadorResponse atualizar(Long id, JogadorRequest request);

    void deletar(Long id);
}