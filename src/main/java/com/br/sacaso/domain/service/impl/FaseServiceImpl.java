package com.br.sacaso.domain.service.impl;

import com.br.sacaso.api.dto.fase.FaseResponse;
import com.br.sacaso.api.mapper.FaseMapper;
import com.br.sacaso.domain.enums.FaseTorneio;
import com.br.sacaso.domain.service.FaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FaseServiceImpl implements FaseService {

    private final FaseMapper faseMapper;

    @Override
    public List<FaseResponse> listarFases() {
        return Arrays.stream(FaseTorneio.values())
                .map(faseMapper::toResponse)
                .toList();
    }
}