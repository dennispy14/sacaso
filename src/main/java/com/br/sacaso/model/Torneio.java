package com.br.sacaso.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Torneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String local;

    private String descricao;

    @OneToMany(mappedBy = "torneio", cascade = CascadeType.ALL)
    private List<Fase> fases;
}