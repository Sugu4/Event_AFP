package com.eventapi.model; 

import jakarta.persistence;
import lombok.Data;
import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "bestellung")
@Data

public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellung_id")
    private Integer bestellungId;

    @Column(name = "bestellung_datum", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime bestellungDatum;

    // Beziehung zu Kunde (n:1)
    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    // Positionen mit Menge, Preis etc.
    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Position> positionen = new ArrayList<>();

    // Zahlungen
    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bezahlung> zahlungen = new ArrayList<>();

    // --- Konstruktoren ---
    public Bestellung() {
    }

    public Bestellung(LocalDateTime bestellungDatum, Kunde kunde) {
        this.bestellungDatum = bestellungDatum;
        this.kunde = kunde;
    }

    // --- Getter & Setter ---
    public Integer getBestellungId() {
        return bestellungId;
    }

    public void setBestellungId(Integer bestellungId) {
        this.bestellungId = bestellungId;
    }

    public LocalDateTime getBestellungDatum() {
        return bestellungDatum;
    }

    public void setBestellungDatum(LocalDateTime bestellungDatum) {
        this.bestellungDatum = bestellungDatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Position> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<Position> positionen) {
        this.positionen = positionen;
    }

    public List<Bezahlung> getZahlungen() {
        return zahlungen;
    }

    public void setZahlungen(List<Bezahlung> zahlungen) {
        this.zahlungen = zahlungen;
    }

    // --- Hilfsmethoden, um Positionen konsistent hinzuzufügen ---
    public void addPosition(Position position) {
        positionen.add(position);
        position.setBestellung(this);
    }

    public void removePosition(Position position) {
        positionen.remove(position);
        position.setBestellung(null);
    }
}
