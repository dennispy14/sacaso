package com.br.sacaso.domain.service.impl;


import com.br.sacaso.api.dto.fase.FaseResponse;
import com.br.sacaso.domain.enums.FaseTorneio;
import com.br.sacaso.domain.service.FaseService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FaseServiceImpl implements FaseService {

    @Override
    public List<FaseResponse> listarFases() {
        return Arrays.stream(FaseTorneio.values())
                .map(f -> new FaseResponse(f.name(), f.getDescricao()))
                .toList();
    }
}