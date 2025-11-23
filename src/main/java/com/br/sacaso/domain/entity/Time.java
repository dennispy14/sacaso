package com.br.sacaso.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    @ManyToMany
    @JoinTable(
            name = "time_jogadores",
            joinColumns = @JoinColumn(name = "time_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    private List<Jogador> jogadores;
}