package com.br.volleyhub.domain.service;

import com.br.volleyhub.api.dto.torneio.TorneioRequest;
import com.br.volleyhub.api.dto.torneio.TorneioResponse;

import java.util.List;

public interface TorneioService {

    TorneioResponse criar(TorneioRequest request);

    List<TorneioResponse> listar();

    TorneioResponse buscarPorId(Long id);

    TorneioResponse atualizar(Long id, TorneioRequest request);

    void deletar(Long id);

    void vincularTime(Long torneioId, Long timeId);

    void desvincularTime(Long torneioId, Long timeId);
}
