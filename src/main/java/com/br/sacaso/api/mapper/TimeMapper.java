package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.time.TimeRequest;
import com.br.sacaso.api.dto.time.TimeResponse;
import com.br.sacaso.domain.entity.Time;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.br.sacaso.api.mapper.JogadorMapper;

@Mapper(componentModel = "spring", uses = {JogadorMapper.class})
public interface TimeMapper {
    @Mapping(target = "nome", source = "name")
    @Mapping(target = "categoria", source = "category")
    @Mapping(target = "imagemUrl", source = "imageUrl")
    Time toEntity(TimeRequest request);

    @Mapping(target = "name", source = "nome")
    @Mapping(target = "category", source = "categoria")    
    @Mapping(target = "imageUrl", source = "imagemUrl")
    // jogadores mapping is automatic via the entity
    TimeResponse toResponse(Time entity);

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "categoria", source = "category")
    @Mapping(target = "imagemUrl", source = "imageUrl")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(TimeRequest request, @MappingTarget Time entity);
}
