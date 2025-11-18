package com.br.sacaso.service;

import com.br.sacaso.model.Jogador;
import com.br.sacaso.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }
}