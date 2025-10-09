package com.eventapi.model;

import jakarta.persistence;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "bestellposition")
@Data

public class Bestellposition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_id")
    private Long id;

    @Column(name = "menge", nullable = false)
    private Integer menge;

    @Column(name = "einzel_preis", nullable = false, precision = 10, scale = 2)
    private BigDecimal einzelPreis;

    // --- Fremdschlüssel ---
    
    // FK zu Bestellung (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestellung_id", nullable = false)
    private Bestellung bestellung;

    // FK zu TicketKategorie (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tk_id", nullable = false)
    private TicketKategorie ticketKategorie;
}
