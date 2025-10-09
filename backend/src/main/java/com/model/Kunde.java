package com.eventapi.model; 

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "kunde")
@Data

public class Kunde {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kunde_id")
    private Long id;

    @Column(name = "kunde_name", nullable = false, length = 255)
    private String name;

    @Column(name = "kunde_vorname", nullable = false, length = 255) 
    private String vorname;

    @Column(name = "kunde_mail", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "kunde_tel", length = 255)
    private String telefon; 
    
    @Column(name = "kunde_geb_datum")
    private LocalDate geburtsdatum;

    // Adressinformationen

    @Column(name = "kunde_strasse", length = 255)
    private String strasse;

    @Column(name = "kunde_plz")
    private Integer plz;

    @Column(name = "kunde_ort", length = 255)
    private String ort;

}
