package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;
    private String titel;
    private LocalDateTime datum;
    private Boolean isPublished;
    private String organisatorName;
    private String locationName;
    private String eventTypName;
}

