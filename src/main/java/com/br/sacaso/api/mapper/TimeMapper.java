package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import com.br.sacaso.domain.entity.Time;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TimeMapper {
    @Mapping(target = "nome", source = "name")
    Time toEntity(TimeRequest request);

    @Mapping(target = "name", source = "nome")
    TimeResponse toResponse(Time entity);

    @Mapping(target = "nome", source = "name")
    void updateEntityFromRequest(TimeRequest request, @MappingTarget Time entity);
}
