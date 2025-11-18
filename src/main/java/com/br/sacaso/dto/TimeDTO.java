package com.br.sacaso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDTO {
    private Long id;
    private String nome;
    private List<JogadorDTO> jogadores;
}