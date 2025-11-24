package com.br.sacaso.domain.service;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;

import java.util.List;

public interface TorneioService {

    TorneioResponse criar(TorneioRequest request);

    List<TorneioResponse> listar();

    TorneioResponse buscarPorId(Long id);

    TorneioResponse atualizar(Long id, TorneioRequest request);

    void deletar(Long id);
}
