package com.eventapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "qr_code", unique = true, nullable = false, length = 255)
    private String qrCode; // Wird beim Einlass gescannt

    @Column(name = "ist_gescannt", nullable = false)
    private Boolean istGescannt = false; // Einlasskontrolle

    // --- Fremdschlüssel ---

    // Ein Ticket gehört zu EINER Bestellposition (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pos_id", nullable = false)
    private Bestellposition bestellposition;
}
