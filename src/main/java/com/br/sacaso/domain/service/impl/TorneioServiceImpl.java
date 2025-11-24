package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.Torneio;
import com.br.sacaso.domain.repository.TorneioRepository;
import com.br.sacaso.domain.service.TorneioService;
import com.br.sacaso.api.mapper.TorneioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TorneioServiceImpl implements TorneioService {

    private final TorneioRepository repository;
    private final TorneioMapper mapper;

    @Override
    public TorneioResponse criar(TorneioRequest request) {
        Torneio entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<TorneioResponse> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public TorneioResponse buscarPorId(Long id) {
        Torneio entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    public TorneioResponse atualizar(Long id, TorneioRequest request) {
        Torneio entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));

        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
