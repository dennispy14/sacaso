package com.br.sacaso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {
    private Long id;
    private Long faseId;
    private TimeDTO timeA;
    private TimeDTO timeB;
    private Integer pontosTimeA;
    private Integer pontosTimeB;
}