package com.br.sacaso.domain.enums;

public enum FaseTorneio {
    GRUPOS("Fase de Grupos"),
    OITAVAS("Oitavas de Final"),
    QUARTAS("Quartas de Final"),
    SEMIFINAL("Semifinal"),
    FINAL("Final");

    private final String descricao;

    FaseTorneio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}