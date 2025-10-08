package com.eventapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bezahlart")
@Data

public class Bezahlart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bezahlart_id")
    private Long id;

    @Column(name = "bezahlart_name", nullable = false, length = 255 VARCHAR)
    private String name;
}
