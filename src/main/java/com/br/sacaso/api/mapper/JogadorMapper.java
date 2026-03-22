package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.jogador.JogadorRequest;
import com.br.sacaso.api.dto.jogador.JogadorResponse;
import com.br.sacaso.domain.entity.Jogador;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "idade", source = "age")
    @Mapping(target = "genero", source = "gender")
    @Mapping(target = "posicao", source = "position")
    @Mapping(target = "time.nome", source = "team")
    @Mapping(target = "imagemUrl", source = "imageUrl")
    Jogador toEntity(JogadorRequest request);

    @Mapping(target = "name", source = "nome")
    @Mapping(target = "age", source = "idade")
    @Mapping(target = "gender", source = "genero")
    @Mapping(target = "position", source = "posicao")
    @Mapping(target = "team", source = "time.nome")
    @Mapping(target = "imageUrl", source = "imagemUrl")
    JogadorResponse toResponse(Jogador entity);

    @Mapping(target = "nome", source = "name")
    @Mapping(target = "idade", source = "age")
    @Mapping(target = "genero", source = "gender")
    @Mapping(target = "posicao", source = "position")
    @Mapping(target = "time.nome", source = "team")
    @Mapping(target = "imagemUrl", source = "imageUrl")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(JogadorRequest request, @MappingTarget Jogador entity);
}
