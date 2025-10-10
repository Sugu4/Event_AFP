package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

import org.hibernate.annotations.CreationTimestamp;

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

   
    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bestellposition> positionen = new ArrayList<>();

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bezahlung> zahlungen = new ArrayList<>();

    public Bestellung() {
    }

    public Bestellung(LocalDateTime bestellungDatum, Kunde kunde) {
        this.bestellungDatum = bestellungDatum;
        this.kunde = kunde;
    }

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

    public List<Bestellposition> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<Bestellposition> positionen) {
        this.positionen = positionen;
    }

    public List<Bezahlung> getZahlungen() {
        return zahlungen;
    }

    public void setZahlungen(List<Bezahlung> zahlungen) {
        this.zahlungen = zahlungen;
    }

    
    public void addPosition(Position position) {
        positionen.add((Bestellposition) position);
        ((Bestellposition) position).setBestellung(this);
    }

    public void removePosition(Position position) {
        positionen.remove(position);
        ((Bestellposition) position).setBestellung(null);
    }
}
