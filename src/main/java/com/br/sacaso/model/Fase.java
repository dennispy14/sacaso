package com.br.sacaso.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    private Torneio torneio;

    @OneToMany(mappedBy = "fase", cascade = CascadeType.ALL)
    private List<Partida> partidas;
}