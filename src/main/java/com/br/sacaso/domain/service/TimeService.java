package com.br.sacaso.domain.service;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;

import java.util.List;

public interface TimeService {

    TimeResponse criar(TimeRequest request);

    List<TimeResponse> listar();

    TimeResponse buscarPorId(Long id);

    TimeResponse atualizar(Long id, TimeRequest request);

    void deletar(Long id);
}
