package com.br.volleyhub.api.mapper;

import com.br.volleyhub.api.dto.fase.FaseResponse;
import com.br.volleyhub.domain.enums.FaseTorneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FaseMapper {

    @Mapping(target = "description", source = "descricao")
    FaseResponse toResponse(FaseTorneio fase);
}
