package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.fase.FaseResponse;
import com.br.sacaso.domain.enums.FaseTorneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FaseMapper {

    @Mapping(target = "description", source = "descricao")
    FaseResponse toResponse(FaseTorneio fase);
}
