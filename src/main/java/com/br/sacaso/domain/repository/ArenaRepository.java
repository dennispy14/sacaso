package com.br.sacaso.domain.repository;

import com.br.sacaso.domain.entity.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long> {
}
