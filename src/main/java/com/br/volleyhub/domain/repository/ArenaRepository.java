package com.br.volleyhub.domain.repository;

import com.br.volleyhub.domain.entity.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long> {
}
