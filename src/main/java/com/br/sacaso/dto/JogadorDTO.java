package com.br.sacaso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String genero;
}