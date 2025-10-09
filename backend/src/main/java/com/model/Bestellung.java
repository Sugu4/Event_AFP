package com.eventapi.model; 

import jakarta.persistence;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bestellung")
@Data

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bestellung")
public class Bestellung {
<<<<<<< HEAD
    
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
=======

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellung_id")
    private Integer bestellungId;

    @Column(name = "bestellung_datum", nullable = false)
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
>>>>>>> f48cbba053275bebf1619c86276f393b3104803e
