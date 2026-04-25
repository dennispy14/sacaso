package com.br.volleyhub.domain.entity;

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
public class GameRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pointsPerSet;
    private Integer pointsLastSet;
    private Integer setsToWin;
    private Boolean twoPointAdvantage;
    private Boolean differentRulesForKnockout;
    private Integer knockoutPointsPerSet;
    private Integer knockoutSetsToWin;
    private Integer estimatedMatchMinutes;
    private boolean thirdPlaceMatch;
}

