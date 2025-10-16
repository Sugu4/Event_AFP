package com.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(name = "bestellung")
@Data
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellung_id")
    private Integer bestellungId;

    @Column(name = "bestellung_datum", nullable = false, updatable = false)
    private LocalDateTime bestellungDatum;
    
    @PrePersist 
    protected void onCreate() {
        if (this.bestellungDatum == null) {
            this.bestellungDatum = LocalDateTime.now();
        }
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bestellposition> positionen = new ArrayList<>();

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bezahlung> zahlungen = new ArrayList<>();

    @Column(name = "bestell_status", nullable = false, length = 50) // <-- FEHLTE
    private String status = "PENDING";



    public void addPosition(Bestellposition position) {
        this.positionen.add(position);
        position.setBestellung(this);
    }

    public void removePosition(Bestellposition position) {
        this.positionen.remove(position);
        position.setBestellung(null);
    }
}