package com.eventapi.model; 

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bestellung")
@Data

public class Bestellung {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellung_id")
    private Long id; // PK INT

    @Column(name = "bestell_datum_zeit", nullable = false)
    private LocalDateTime bestellDatumZeit = LocalDateTime.now();

    @Column(name = "gesamt_preis", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal gesamtPreis;

    @Column(name = "bestell_status", nullable = false, length = 50)
    private String status; 
    
    @Column(name = "kunde_vorname", length = 100)
    private String vorname;
    
    @Column(name = "kunde_nachname", length = 100)
    private String nachname;
    
    @Column(name = "kunde_email", nullable = false, length = 255)
    private String email;

    // Fremdschlüssel 
    
    // FK zu Bezahlart (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bezahlart_id", nullable = false)
    private Bezahlart bezahlart;
    

}