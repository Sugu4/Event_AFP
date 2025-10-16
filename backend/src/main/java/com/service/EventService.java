package com.service; 

import com.model.Event;
import com.model.TicketKategorie;
import com.repository.EventRepository;
import com.repository.BestellpositionRepository; 
import com.dto.EventDetailsDto; 
import com.dto.TicketKategorieDto; 
import com.model.Organisator;
import com.model.Location;
import com.model.EventTyp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
import java.util.List;
import java.util.NoSuchElementException;
import java.math.BigDecimal; 

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final BestellpositionRepository bestellpositionRepository; 

    public EventService(EventRepository eventRepository, BestellpositionRepository bestellpositionRepository) {
        this.eventRepository = eventRepository;
        this.bestellpositionRepository = bestellpositionRepository;
    }

    
    public EventDetailsDto getEventDetailsWithAvailability(Long eventId) {
        
        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new NoSuchElementException("Event nicht gefunden: " + eventId));

        EventDetailsDto dto = convertToEventDetailsDto(event);

        List<TicketKategorieDto> tkDtos = event.getTicketKategorien().stream()
            .map(ticketKat -> calculateAvailability(ticketKat))
            .toList();

        dto.setTicketKategorien(tkDtos);
        return dto;
    }

    public List<EventDetailsDto> getAllEventsAsDtos() {
        return eventRepository.findAll().stream()
            .map(this::convertToEventDetailsDto)
            .toList();
    }



    private TicketKategorieDto calculateAvailability(TicketKategorie ticketKat) {
        
        Long verkauft = bestellpositionRepository.sumSoldTicketsByTicketKategorieId(ticketKat.getId());
        
        Integer kontingentMax = ticketKat.getKontingentMax();
        int verfuegbar = kontingentMax - verkauft.intValue(); 

        TicketKategorieDto dto = new TicketKategorieDto();
        dto.setId(ticketKat.getId());
        dto.setName(ticketKat.getName());
        dto.setPreis(ticketKat.getPreis());
        dto.setKontingentMax(kontingentMax);
        dto.setVerkauft(verkauft);
        dto.setVerfuegbar(verfuegbar);
        
        return dto;
    }
    
    private EventDetailsDto convertToEventDetailsDto(Event event) {
        EventDetailsDto dto = new EventDetailsDto();
        dto.setId(event.getId());
        dto.setTitel(event.getTitel());
        dto.setStartDatumZeit(event.getDatum()); 
        dto.setOrganisatorName(event.getOrganisator().getName());
        dto.setLocationName(event.getLocation().getName()); 
        dto.setEventTypName(event.getEventTyp().getName());
        return dto;
    }


    
    @Transactional
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    
}