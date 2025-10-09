package com.eventapi.model;

import jakarta.persistence;
import lombok.Data;
import java.math.BigDecimal; // Prezise Währungsberechnung

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

    // --- Fremdschlüssel ---

    // Eine TicketKategorie gehört zu EINEM Event (N:1-Beziehung)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
