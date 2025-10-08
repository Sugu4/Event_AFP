package com.eventapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event_typ")
@Data
public class EventTyp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_typ_id")
    private Long id;

     @Column(name = "event_typ_name", nullable = false, length = VARCHAR(255))
     private String name;
}
