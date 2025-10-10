package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "organisator")
@Data
public class Organisator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long id;

    @Column(name = "org_name", nullable = false, length = 255)
    private String name;

    @Column(name = "org_mail", unique = true, length = 255)
    private String email;

    @Column(name = "org_iban", length = 22)
    private String iban;

    // Adressfelder
    @Column(name = "org_strasse", length = 255)
    private String strasse;

    @Column(name = "org_plz")
    private Integer plz;

    @Column(name = "org_ort", length = 255)
    private String ort;
}
