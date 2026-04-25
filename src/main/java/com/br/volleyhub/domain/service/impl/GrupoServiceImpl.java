package com.br.volleyhub.domain.service.impl;

import com.br.volleyhub.api.dto.grupo.GrupoRequest;
import com.br.volleyhub.api.dto.grupo.GrupoResponse;
import com.br.volleyhub.api.mapper.GrupoMapper;
import com.br.volleyhub.domain.entity.Grupo;
import com.br.volleyhub.domain.entity.Time;
import com.br.volleyhub.domain.entity.Torneio;
import com.br.volleyhub.domain.repository.GrupoRepository;
import com.br.volleyhub.domain.repository.TimeRepository;
import com.br.volleyhub.domain.repository.TorneioRepository;
import com.br.volleyhub.domain.service.GrupoService;
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
                .orElseThrow(() -> new RuntimeException("Torneio nÃ£o encontrado"));
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
                .orElseThrow(() -> new RuntimeException("Grupo nÃ£o encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public GrupoResponse atualizar(Long id, GrupoRequest request) {
        Grupo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo nÃ£o encontrado"));
        
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
                .orElseThrow(() -> new RuntimeException("Grupo nÃ£o encontrado"));
        List<Time> times = timeRepository.findAllById(timeIds);
        entity.setTimes(times);
        repository.save(entity);
    }
}
