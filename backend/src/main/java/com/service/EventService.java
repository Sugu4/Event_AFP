package com.service;

import com.model.Event;
import com.repository.EventRepository;
import com.repository.TicketKategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository, TicketKategorieRepository ticketKategorieRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getEventDetailsWithAvailability(Long eventId) {
        return eventRepository.findByIdWithDetails(eventId)
                .orElseThrow(() -> new NoSuchElementException("Event nicht gefunden: " + eventId));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        if (!eventRepository.existsById(event.getId())) {
            throw new NoSuchElementException("Event nicht gefunden: " + event.getId());
        }
        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new NoSuchElementException("Event nicht gefunden: " + eventId);
        }
        eventRepository.deleteById(eventId);
    }
}