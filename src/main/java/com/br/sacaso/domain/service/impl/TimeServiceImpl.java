package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.repository.TimeRepository;
import com.br.sacaso.domain.service.TimeService;
import com.br.sacaso.api.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeRepository repository;
    private final TimeMapper mapper;

    @Override
    public TimeResponse criar(TimeRequest request) {
        Time entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<TimeResponse> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public TimeResponse buscarPorId(Long id) {
        Time entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    public TimeResponse atualizar(Long id, TimeRequest request) {
        Time entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));

        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
