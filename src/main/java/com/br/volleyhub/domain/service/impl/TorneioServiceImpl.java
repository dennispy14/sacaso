package com.br.volleyhub.domain.service.impl;

import com.br.volleyhub.api.dto.torneio.TorneioRequest;
import com.br.volleyhub.api.dto.torneio.TorneioResponse;
import com.br.volleyhub.domain.entity.Arena;
import com.br.volleyhub.domain.entity.Torneio;
import com.br.volleyhub.domain.entity.Time;
import com.br.volleyhub.domain.repository.ArenaRepository;
import com.br.volleyhub.domain.repository.TorneioRepository;
import com.br.volleyhub.domain.repository.TimeRepository;
import com.br.volleyhub.domain.service.TorneioService;
import com.br.volleyhub.api.mapper.TorneioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TorneioServiceImpl implements TorneioService {

    private final TorneioRepository repository;
    private final TorneioMapper mapper;
    private final TimeRepository timeRepository;
    private final ArenaRepository arenaRepository;

    @Override
    public TorneioResponse criar(TorneioRequest request) {
        Torneio entity = mapper.toEntity(request);
        if (entity.getConfig() != null && entity.getConfig().getPhases() != null) {
            System.out.println("Salvar Torneio com " + entity.getConfig().getPhases().size() + " fases");
        }
        if (request.arenaId() != null) {
            Arena arena = arenaRepository.findById(request.arenaId())
                    .orElseThrow(() -> new RuntimeException("Arena nÃ£o encontrada"));
            entity.setArena(arena);
        }
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
                .orElseThrow(() -> new RuntimeException("Torneio nÃ£o encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    public TorneioResponse atualizar(Long id, TorneioRequest request) {
        Torneio entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio nÃ£o encontrado"));

        mapper.updateEntityFromRequest(request, entity);
        if (request.arenaId() != null) {
            Arena arena = arenaRepository.findById(request.arenaId())
                    .orElseThrow(() -> new RuntimeException("Arena nÃ£o encontrada"));
            entity.setArena(arena);
        }
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void vincularTime(Long torneioId, Long timeId) {
        Torneio torneio = repository.findById(torneioId)
                .orElseThrow(() -> new RuntimeException("Torneio nÃ£o encontrado"));

        if (torneio.getStatus() != null && !torneio.getStatus().equals("planejado")) {
            throw new RuntimeException("NÃ£o Ã© permitido vincular times apÃ³s o inÃ­cio do torneio");
        }

        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time nÃ£o encontrado"));

        if (torneio.getTimes() == null) {
            torneio.setTimes(new ArrayList<>());
        }

        boolean alreadyLinked = torneio.getTimes().stream()
                .anyMatch(existingTime -> existingTime.getId().equals(time.getId()));

        if (!alreadyLinked) {
            torneio.getTimes().add(time);
            repository.save(torneio);
        }
    }

    @Override
    @Transactional
    public void desvincularTime(Long torneioId, Long timeId) {
        Torneio torneio = repository.findById(torneioId)
                .orElseThrow(() -> new RuntimeException("Torneio nÃ£o encontrado"));

        if (torneio.getStatus() != null && !torneio.getStatus().equals("planejado")) {
            throw new RuntimeException("NÃ£o Ã© permitido desvincular times apÃ³s o inÃ­cio do torneio");
        }

        if (torneio.getTimes() != null) {
            boolean removed = torneio.getTimes().removeIf(existingTime -> existingTime.getId().equals(timeId));
            if (removed) {
                repository.save(torneio);
            }
        }
    }
}
