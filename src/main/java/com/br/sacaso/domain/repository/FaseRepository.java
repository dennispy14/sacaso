package com.br.sacaso.domain.repository;

import com.br.sacaso.domain.entity.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long> {
}
