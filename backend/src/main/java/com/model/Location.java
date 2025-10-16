package com.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
@Data
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private Long id;

    @Column(name = "loc_name", nullable = false, length = 255)
    private String name;

    @Column(name = "max_kapazitaet", nullable = false)
    private Integer maxKapazitaet; 

    // Adressfelder
    @Column(name = "loc_strasse", nullable = false, length = 255)
    private String strasse;

    @Column(name = "loc_plz", nullable = false)
    private Integer plz;

    @Column(name = "loc_ort", nullable = false, length = 255)
    private String ort;
    
    // Bankdaten (optional)
    @Column(name = "loc_iban", length = 22)
    private String iban;
}
