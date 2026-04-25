package com.br.volleyhub.domain.service;

import com.br.volleyhub.api.dto.grupo.GrupoRequest;
import com.br.volleyhub.api.dto.grupo.GrupoResponse;
import java.util.List;

public interface GrupoService {
    GrupoResponse criar(GrupoRequest request);
    List<GrupoResponse> listarPorTorneio(Long torneioId);
    GrupoResponse buscarPorId(Long id);
    GrupoResponse atualizar(Long id, GrupoRequest request);
    void deletar(Long id);
    void atualizarTimes(Long id, List<Long> timeIds);
}
