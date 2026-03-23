package com.br.sacaso.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Getter @Setter
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

    private LocalTime horaInicio;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "arena_id")
    private Arena arena;

    private String modalidade; // Quarteto | Dupla

    private String categoria;  // Misto | Feminino | Masculino

    private String status; // planejado | em_andamento | finalizado

    @ManyToMany
    @JoinTable(
        name = "torneio_times",
        joinColumns = @JoinColumn(name = "torneio_id"),
        inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private List<Time> times;

}