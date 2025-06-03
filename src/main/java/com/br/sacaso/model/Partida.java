package com.br.sacaso.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Time timeA;

    @ManyToOne
    private Time timeB;

    private Integer pontosTimeA;

    private Integer pontosTimeB;

    private LocalDate dataPartida;

    @ManyToOne
    private Fase fase;
}