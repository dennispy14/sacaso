package com.br.sacaso.domain.entity;

import com.br.sacaso.domain.enums.FaseTorneio;
import com.br.sacaso.domain.enums.StatusPartida;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "torneio_id")
    private Torneio torneio;

    @ManyToOne
    @JoinColumn(name = "time_a_id")
    private Time timeA;

    @ManyToOne
    @JoinColumn(name = "time_b_id")
    private Time timeB;

    private Integer placarA;
    private Integer placarB;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private FaseTorneio fase;

    @Enumerated(EnumType.STRING)
    private StatusPartida status;
}
