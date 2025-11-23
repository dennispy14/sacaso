package com.br.sacaso.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String apelido;

    private Integer idade;

    private String genero;

    private String cidade;
}