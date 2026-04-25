package com.br.volleyhub.domain.repository;

import com.br.volleyhub.domain.entity.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Long> {
}