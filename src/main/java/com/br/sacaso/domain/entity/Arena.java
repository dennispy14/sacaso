package com.br.sacaso.domain.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String Local;

    @ManyToMany
    @JoinTable(
        name = "arena_quadras",
        joinColumns = @JoinColumn(name = "arena_id"),
        inverseJoinColumns = @JoinColumn(name = "quadra_id")
    )
    private List<Quadra> quadras;

    
}