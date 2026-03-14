package Lucas.eventos.controller;

import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.model.dto.EventResponseDTO;
import Lucas.eventos.service.EventService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventRequestDTO dto) {
        Event novoEvent = this.eventService.createEvent(dto);
        return ResponseEntity.ok(novoEvent);

    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> listarEventos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> allEvents = this.eventService.getEvent(page, size);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventResponseDTO>> getUpcomingEvent(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> allEvents = this.eventService.getUpcomingEvent(page, size);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EventResponseDTO>> getFilterEvent(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size,
                                                                 @RequestParam(required = false) String title,
                                                                 @RequestParam(required = false) String city,
                                                                 @RequestParam(required = false) String uf,
                                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        List<EventResponseDTO> filterEvents = this.eventService.getFilterEvent(page, size, title, city, uf, startDate, endDate);
        return ResponseEntity.ok(filterEvents);
    }

}
