package com.br.sacaso.service;

import com.br.sacaso.model.Time;
import com.br.sacaso.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;

    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    public Time buscarPorId(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
    }

    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }
}