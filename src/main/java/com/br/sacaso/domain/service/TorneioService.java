package com.br.sacaso.domain.service;

import com.br.sacaso.domain.entity.Torneio;
import com.br.sacaso.domain.repository.TorneioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TorneioService {

    private final TorneioRepository torneioRepository;

    public Torneio salvar(Torneio torneio) {
        return torneioRepository.save(torneio);
    }

    public List<Torneio> listarTodos() {
        return torneioRepository.findAll();
    }

    public Torneio buscarPorId(Long id) {
        return torneioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
    }

    public void deletar(Long id) {
        torneioRepository.deleteById(id);
    }
}