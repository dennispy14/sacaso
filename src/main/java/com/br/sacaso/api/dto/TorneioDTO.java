package com.br.sacaso.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneioDTO {
    private Long id;
    private String nome;
    private String descricao;
    private List<FaseDTO> fases;
}