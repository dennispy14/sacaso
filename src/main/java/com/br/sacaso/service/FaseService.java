package com.br.sacaso.service;

import com.br.sacaso.model.Fase;
import com.br.sacaso.repository.FaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaseService {

    private final FaseRepository faseRepository;

    public Fase salvar(Fase fase) {
        return faseRepository.save(fase);
    }

    public List<Fase> listarTodas() {
        return faseRepository.findAll();
    }

    public Fase buscarPorId(Long id) {
        return faseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fase não encontrada"));
    }

    public void deletar(Long id) {
        faseRepository.deleteById(id);
    }
}