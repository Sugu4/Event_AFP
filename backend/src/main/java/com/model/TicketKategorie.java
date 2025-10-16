package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_kategorie")
@Data

public class TicketKategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tk_id")
    private Long id;

    @Column(name = "tk_name", nullable = false, length = 255)
    private String name;

    @Column(name = "preis", nullable = false, precision = 10, scale = 2)
    private BigDecimal preis;

    @Column(name = "kontingent_max", nullable = false)
    private Integer kontingentMax; // Die maximale Anzahl an Tickets dieser Kategorie

    @Column(name = "tk_beschreibung", length = 500)
    private String beschreibung;

    // Eine TicketKategorie gehört zu EINEM Event (N:1-Beziehung)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    }

