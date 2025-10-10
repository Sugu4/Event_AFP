package com.service;

import com.eventapi.model.Event;
import com.eventapi.repository.EventRepository;
import com.eventapi.repository.TicketKategorieRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TicketKategorieRepository ticketKategorieRepository;

    public EventService(EventRepository eventRepository, TicketKategorieRepository ticketKategorieRepository) {
        this.eventRepository = eventRepository;
        this.ticketKategorieRepository = ticketKategorieRepository;
    }

    public Event getEventDetailsWithAvailability(Long eventId) {
        
        // 1. Event aus der Datenbank abrufen
        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new NoSuchElementException("Event nicht gefunden: " + eventId));

        // 2. Hier müsste die Logik zur Verfügbarkeitsberechnung folgen.
        // Diese Logik hängt stark von der Datenbankstruktur und den Geschäftsregeln ab.
        
        return event;
    }
}