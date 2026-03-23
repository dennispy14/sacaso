package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.torneio.TorneioRequest;
import com.br.sacaso.api.dto.torneio.TorneioResponse;
import com.br.sacaso.domain.entity.Arena;
import com.br.sacaso.domain.entity.Torneio;
import com.br.sacaso.domain.entity.Time;
import com.br.sacaso.domain.repository.ArenaRepository;
import com.br.sacaso.domain.repository.TorneioRepository;
import com.br.sacaso.domain.repository.TimeRepository;
import com.br.sacaso.domain.service.TorneioService;
import com.br.sacaso.api.mapper.TorneioMapper;
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
                    .orElseThrow(() -> new RuntimeException("Arena não encontrada"));
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
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
        return mapper.toResponse(entity);
    }

    @Override
    public TorneioResponse atualizar(Long id, TorneioRequest request) {
        Torneio entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));

        mapper.updateEntityFromRequest(request, entity);
        if (request.arenaId() != null) {
            Arena arena = arenaRepository.findById(request.arenaId())
                    .orElseThrow(() -> new RuntimeException("Arena não encontrada"));
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
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
        
        if (torneio.getStatus() != null && !torneio.getStatus().equals("planejado")) {
            throw new RuntimeException("Não é permitido vincular times após o início do torneio");
        }

        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));

        if (torneio.getTimes() == null) {
            torneio.setTimes(new ArrayList<>());
        }
        if (!torneio.getTimes().contains(time)) {
            torneio.getTimes().add(time);
            repository.save(torneio);
        }
    }

    @Override
    @Transactional
    public void desvincularTime(Long torneioId, Long timeId) {
        Torneio torneio = repository.findById(torneioId)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));

        if (torneio.getStatus() != null && !torneio.getStatus().equals("planejado")) {
            throw new RuntimeException("Não é permitido desvincular times após o início do torneio");
        }

        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));

        if (torneio.getTimes() != null && torneio.getTimes().contains(time)) {
            torneio.getTimes().remove(time);
            repository.save(torneio);
        }
    }
}
