package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import com.br.sacaso.domain.entity.Time;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TimeMapper {

    Time toEntity(TimeRequest request);

    TimeResponse toResponse(Time entity);

    void updateEntityFromRequest(TimeRequest request, @MappingTarget Time entity);
}
