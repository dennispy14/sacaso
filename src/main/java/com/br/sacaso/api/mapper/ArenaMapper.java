package com.br.sacaso.api.mapper;

import com.br.sacaso.api.dto.arena.ArenaResponse;
import com.br.sacaso.domain.entity.Arena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArenaMapper {
    ArenaResponse toResponse(Arena arena);
}
