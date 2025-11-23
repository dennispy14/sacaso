package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.request.JogadorRequest;
import com.br.sacaso.api.dto.response.JogadorResponse;
import com.br.sacaso.domain.entity.Jogador;
import com.br.sacaso.domain.repository.JogadorRepository;
import com.br.sacaso.domain.service.JogadorService;
import com.br.sacaso.mapper.JogadorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final JogadorMapper jogadorMapper;

    @Override
    public JogadorResponse criar(JogadorRequest request) {
        Jogador jogador = jogadorMapper.toEntity(request);
        Jogador salvo = jogadorRepository.save(jogador);
        return jogadorMapper.toResponse(salvo);
    }

    @Override
    public List<JogadorResponse> listar() {
        return jogadorRepository.findAll()
                .stream()
                .map(jogadorMapper::toResponse)
                .toList();
    }

    @Override
    public JogadorResponse buscarPorId(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        return jogadorMapper.toResponse(jogador);
    }

    @Override
    public JogadorResponse atualizar(Long id, JogadorRequest request) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        jogadorMapper.updateEntityFromRequest(request, jogador);

        Jogador atualizado = jogadorRepository.save(jogador);
        return jogadorMapper.toResponse(atualizado);
    }

    @Override
    public void deletar(Long id) {
        if (!jogadorRepository.existsById(id)) {
            throw new RuntimeException("Jogador não encontrado");
        }
        jogadorRepository.deleteById(id);
    }
}