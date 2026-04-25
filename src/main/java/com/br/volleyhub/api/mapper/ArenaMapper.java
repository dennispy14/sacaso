package com.br.volleyhub.api.mapper;

import com.br.volleyhub.api.dto.arena.ArenaResponse;
import com.br.volleyhub.domain.entity.Arena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArenaMapper {
    ArenaResponse toResponse(Arena arena);
}
