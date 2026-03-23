package com.br.sacaso.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean enabled;
    private Integer gold;
    private Integer silver;
    private Integer bronze;
    private Integer numberOfSeries;
    private Integer teamsPerSeries;
    private String matchFormat;
}
