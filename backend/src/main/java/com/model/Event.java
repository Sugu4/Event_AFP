package com.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Data

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_titel", nullable = false, length = 255)
    private String titel;

    @Column(name = "event_beschreibung_kurz", length = 500)
    private String beschreibungKurz;

    @Column(name = "datum", nullable = false)
    private LocalDateTime Datum;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished = false;

    // Ein Event hat EINEN Organisator (N:1-Beziehung)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organisator organisator;

    // Ein Event hat EINE Location (N:1-Beziehung)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loc_id", nullable = false)
    private Location location;

    // Ein Event hat EINEN EventTyp (N:1-Beziehung)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_typ_id", nullable = false)
    private EventTyp eventTyp;

    // Anmerkung: Die 1:N-Verknüpfung zu TicketKategorie kommt später, da diese 
    // 'Event'-ID als FK enthalten
}
