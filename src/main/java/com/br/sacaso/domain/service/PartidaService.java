package com.br.sacaso.domain.service;

import com.br.sacaso.domain.entity.Partida;
import com.br.sacaso.domain.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public Partida salvar(Partida partida) {
        return partidaRepository.save(partida);
    }

    public List<Partida> listarTodas() {
        return partidaRepository.findAll();
    }

    public Partida buscarPorId(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));
    }

    public void deletar(Long id) {
        partidaRepository.deleteById(id);
    }
}