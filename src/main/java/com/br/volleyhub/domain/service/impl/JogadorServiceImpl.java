package com.br.volleyhub.domain.service.impl;

import com.br.volleyhub.api.dto.jogador.JogadorRequest;
import com.br.volleyhub.api.dto.jogador.JogadorResponse;
import com.br.volleyhub.domain.entity.Jogador;
import com.br.volleyhub.domain.entity.Time;
import com.br.volleyhub.domain.repository.JogadorRepository;
import com.br.volleyhub.domain.repository.TimeRepository;
import com.br.volleyhub.domain.service.JogadorService;
import com.br.volleyhub.api.mapper.JogadorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;
    private final JogadorMapper jogadorMapper;

    @Override
    public JogadorResponse criar(JogadorRequest request) {
        Jogador jogador = jogadorMapper.toEntity(request);
        
        if (request.team() != null && !request.team().isBlank()) {
            Time time = timeRepository.findByNome(request.team())
                    .orElseThrow(() -> new RuntimeException("Time nÃ£o encontrado"));
            jogador.setTime(time);
        }
        
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
                .orElseThrow(() -> new RuntimeException("Jogador nÃ£o encontrado"));
        return jogadorMapper.toResponse(jogador);
    }

    @Override
    public JogadorResponse atualizar(Long id, JogadorRequest request) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador nÃ£o encontrado"));

        jogadorMapper.updateEntityFromRequest(request, jogador);

        if (request.team() != null && !request.team().isBlank()) {
            Time time = timeRepository.findByNome(request.team())
                    .orElseThrow(() -> new RuntimeException("Time nÃ£o encontrado"));
            jogador.setTime(time);
        } else {
            jogador.setTime(null);
        }

        Jogador atualizado = jogadorRepository.save(jogador);
        return jogadorMapper.toResponse(atualizado);
    }

    @Override
    public void deletar(Long id) {
        if (!jogadorRepository.existsById(id)) {
            throw new RuntimeException("Jogador nÃ£o encontrado");
        }
        jogadorRepository.deleteById(id);
    }
}