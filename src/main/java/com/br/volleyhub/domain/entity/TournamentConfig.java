package com.br.volleyhub.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_rules_id")
    private GameRules gameRules;

    @Deprecated
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_config_id")
    @Builder.Default
    private List<TournamentPhase> phases = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_config_id")
    private GroupConfig groups;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "series_config_id")
    private SeriesConfig series;
}
