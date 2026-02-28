package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.partida.*;
import com.br.sacaso.api.mapper.PartidaMapper;
import com.br.sacaso.domain.enums.StatusPartida;
import com.br.sacaso.domain.repository.*;
import com.br.sacaso.domain.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;
    private final TorneioRepository torneioRepository;
    private final TimeRepository timeRepository;
    private final PartidaMapper mapper;

    @Override
    public PartidaResponse criar(PartidaRequest req) {

        var torneio = torneioRepository.findById(req.tournamentId())
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));

        var timeA = timeRepository.findById(req.teamAId())
                .orElseThrow(() -> new RuntimeException("Time A não encontrado"));

        var timeB = timeRepository.findById(req.teamBId())
                .orElseThrow(() -> new RuntimeException("Time B não encontrado"));

        var partida = mapper.toEntity(req, torneio, timeA, timeB);

        return mapper.toResponse(partidaRepository.save(partida));
    }

    @Override
    public List<PartidaResponse> listarPorTorneio(Long torneioId) {
        return partidaRepository.findByTorneioId(torneioId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PartidaResponse buscarPorId(Long id) {
        return partidaRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));
    }

    @Override
    public PartidaResponse atualizarPlacar(Long id, Integer placarA, Integer placarB) {
        var partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));

        partida.setPlacarA(placarA);
        partida.setPlacarB(placarB);
        partida.setStatus(StatusPartida.FINALIZADA);

        return mapper.toResponse(partidaRepository.save(partida));
    }

    @Override
    public PartidaResponse atualizarStatus(Long id, StatusPartida novoStatus) {
        var partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));

        // validação básica de transição de status
        if (!isValidTransition(partida.getStatus(), novoStatus)) {
            throw new IllegalStateException(
                    "Transição de status inválida: " + partida.getStatus() + " -> " + novoStatus);
        }

        partida.setStatus(novoStatus);
        partidaRepository.save(partida);
        return mapper.toResponse(partida);
    }

    private boolean isValidTransition(StatusPartida atual, StatusPartida novoStatus) {
        if (atual == null)
            return true;
        switch (atual) {
            case AGENDADA:
                return novoStatus == StatusPartida.EM_ANDAMENTO || novoStatus == StatusPartida.CANCELADA;
            case EM_ANDAMENTO:
                return novoStatus == StatusPartida.FINALIZADA || novoStatus == StatusPartida.CANCELADA;
            case FINALIZADA:
                // permitir reabertura só com regra/flag especial (não permitida por padrão)
                return false;
            case CANCELADA:
                return false;
            default:
                return false;
        }
    }
}