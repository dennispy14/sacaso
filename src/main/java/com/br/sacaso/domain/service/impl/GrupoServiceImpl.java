package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.grupo.GrupoRequest;
import com.br.sacaso.api.dto.grupo.GrupoResponse;
import com.br.sacaso.api.mapper.GrupoMapper;
import com.br.sacaso.domain.entity.Grupo;
import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.entity.Torneio;
import com.br.sacaso.domain.repository.GrupoRepository;
import com.br.sacaso.domain.repository.TimeRepository;
import com.br.sacaso.domain.repository.TorneioRepository;
import com.br.sacaso.domain.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository repository;
    private final TorneioRepository torneioRepository;
    private final TimeRepository timeRepository;
    private final GrupoMapper mapper;

    @Override
    @Transactional
    public GrupoResponse criar(GrupoRequest request) {
        Grupo entity = mapper.toEntity(request);
        
        Torneio torneio = torneioRepository.findById(request.torneioId())
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
        entity.setTorneio(torneio);

        if (request.timeIds() != null && !request.timeIds().isEmpty()) {
            List<Time> times = timeRepository.findAllById(request.timeIds());
            entity.setTimes(times);
        }

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<GrupoResponse> listarPorTorneio(Long torneioId) {
        return repository.findByTorneioId(torneioId).stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public GrupoResponse buscarPorId(Long id) {
        Grupo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public GrupoResponse atualizar(Long id, GrupoRequest request) {
        Grupo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        
        mapper.updateEntityFromRequest(request, entity);

        if (request.timeIds() != null) {
            List<Time> times = timeRepository.findAllById(request.timeIds());
            entity.setTimes(times);
        }

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void atualizarTimes(Long id, List<Long> timeIds) {
        Grupo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        List<Time> times = timeRepository.findAllById(timeIds);
        entity.setTimes(times);
        repository.save(entity);
    }
}
