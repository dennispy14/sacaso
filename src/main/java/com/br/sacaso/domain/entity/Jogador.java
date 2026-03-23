package com.br.sacaso.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jogadores")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String apelido;

    private Integer idade;

    private String genero;

    private String posicao;

    private String status;

    private String cidade;
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}