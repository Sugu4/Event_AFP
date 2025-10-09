package com.eventapi.controller;

import com.eventapi.model.Event;
import com.eventapi.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    
    private final EventService eventService;
    
    public EventController(EventService eventService) { 
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long eventID) {
        try {
            Event event = eventService.getEventDetailsWithAvailability(eventID);
            return ResponseEntity.ok(event);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        
        } catch (Exception e) { 
            return ResponseEntity.internalServerError().body(null);

        }
    }
}