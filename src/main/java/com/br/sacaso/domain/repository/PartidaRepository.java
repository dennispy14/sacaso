package com.br.sacaso.domain.repository;

import com.br.sacaso.domain.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByTorneioId(Long torneioId);
}