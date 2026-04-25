package com.br.volleyhub.domain.service.impl;

import com.br.volleyhub.api.dto.fase.FaseResponse;
import com.br.volleyhub.api.mapper.FaseMapper;
import com.br.volleyhub.domain.enums.FaseTorneio;
import com.br.volleyhub.domain.service.FaseService;
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