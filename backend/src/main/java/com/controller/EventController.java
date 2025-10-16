package com.controller;

import com.dto.EventDetailsDto;
import com.model.Event;
import com.service.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    
    private final EventService eventService;
    
    public EventController(EventService eventService) { 
        this.eventService = eventService;
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<EventDetailsDto> getEventById(@PathVariable("id") Long eventID) {
        try {
            EventDetailsDto eventDto = eventService.getEventDetailsWithAvailability(eventID); 
            return ResponseEntity.ok(eventDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        
        } catch (Exception e) { 
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EventDetailsDto>> getAllEvents() {
        List<EventDetailsDto> dtos = eventService.getAllEventsAsDtos();
        
        return ResponseEntity.ok(dtos);
    }
    
}