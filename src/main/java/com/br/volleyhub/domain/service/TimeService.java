package com.br.volleyhub.domain.service;

import com.br.volleyhub.api.dto.time.TimeRequest;
import com.br.volleyhub.api.dto.time.TimeResponse;

import java.util.List;

public interface TimeService {

    TimeResponse criar(TimeRequest request);

    List<TimeResponse> listar();

    TimeResponse buscarPorId(Long id);

    TimeResponse atualizar(Long id, TimeRequest request);

    void deletar(Long id);
}
