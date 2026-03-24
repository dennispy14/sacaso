package com.br.sacaso.domain.entity;

import java.util.List;

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
@Table(name = "arena")
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String local;
    private String bairro;
    private String cidade;
    private String imagemUrl;


    @ManyToMany
    @JoinTable(
        name = "arena_quadras",
        joinColumns = @JoinColumn(name = "arena_id"),
        inverseJoinColumns = @JoinColumn(name = "quadra_id")
    )
    private List<Quadra> quadras;
}