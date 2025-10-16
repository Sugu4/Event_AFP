package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List; // Import für die Liste hinzufügen

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDetailsDto {
    private Long id;
    private String titel;
    // Start- und Enddatum für genaue Eventzeiten
    private LocalDateTime startDatumZeit; 
    private LocalDateTime endDatumZeit; 
    
    // Basis-Informationen
    private String organisatorName;
    private String locationName;
    private String eventTypName;

    // WICHTIG: das berechnete Child-DTO
    private List<TicketKategorieDto> ticketKategorien;
}