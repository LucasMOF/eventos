package Lucas.eventos.controller;

import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.model.dto.EventResponseDTO;
import Lucas.eventos.service.EventService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<EventResponseDTO> allEvents= this.eventService.getEvent(page, size);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventResponseDTO>> getUpcomingEvent(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> allEvents= this.eventService.getUpcomingEvent(page, size);
        return ResponseEntity.ok(allEvents);
    }

}
