package com.br.sacaso.domain.service;

import com.br.sacaso.api.dto.grupo.GrupoRequest;
import com.br.sacaso.api.dto.grupo.GrupoResponse;
import java.util.List;

public interface GrupoService {
    GrupoResponse criar(GrupoRequest request);
    List<GrupoResponse> listarPorTorneio(Long torneioId);
    GrupoResponse buscarPorId(Long id);
    GrupoResponse atualizar(Long id, GrupoRequest request);
    void deletar(Long id);
    void atualizarTimes(Long id, List<Long> timeIds);
}
