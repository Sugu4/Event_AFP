package com.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bezahlung")
@Data
public class Bezahlung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bezahlung_id")
    private Long id;

    @Column(name = "bezahlung_zeit", nullable = false)
    private LocalDateTime bezahlungZeit = LocalDateTime.now();

    @Column(name = "transaktions_id", length = 255)
    private String transaktionsId;


    // N:1 Eine Bezahlung gehört zu EINER Bestellung.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestellung_id", nullable = false)
    private Bestellung bestellung;

    // FK zu Bezahlart (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bezahlart_id", nullable = false)
    private Bezahlart bezahlart;
}