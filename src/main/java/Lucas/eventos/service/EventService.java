package Lucas.eventos.service;

import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.model.dto.EventResponseDTO;
import Lucas.eventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private AddressService addressService;

    public Event createEvent(EventRequestDTO dto) {
        Event novoEvent = new Event();

        novoEvent.setTitulo(dto.titulo());
        novoEvent.setDescricao(dto.descricao());
        novoEvent.setDate(dto.date());
        novoEvent.setRemote(dto.remote());

        repository.save(novoEvent);

        if (!dto.remote()) {
            this.addressService.createAddress(dto, novoEvent);
        }
        return novoEvent;
    }

    public List<EventResponseDTO> getEvent(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventsPage = this.repository.findAll(pageable);
        return eventsPage.map(event -> new EventResponseDTO(event.getId(),
                        event.getTitulo(),
                        event.getDescricao(),
                        event.getDate(),
                        event.getRemote(),
                        event.getAddress() != null ? event.getAddress().getCity() : "",
                        event.getAddress() != null ? event.getAddress().getUf() : ""
                ))
                .stream().toList();
    }

    public List<EventResponseDTO> getUpcomingEvent(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventsPage = this.repository.findUpcomingEvents(new Date(), pageable);
        return eventsPage.map(event -> new EventResponseDTO(event.getId(),
                        event.getTitulo(),
                        event.getDescricao(),
                        event.getDate(),
                        event.getRemote(),
                        event.getAddress() != null ? event.getAddress().getCity() : "",
                        event.getAddress() != null ? event.getAddress().getUf() : ""
                ))
                .stream().toList();
    }

    public List<EventResponseDTO> getFilterEvent(int page, int size, String title, String city, String uf, Date startDate, Date endDate) {
        title = (title != null) ? title : "";
        city = (city != null) ? city : "";
        uf = (uf != null) ? uf : "";
        startDate = (startDate != null) ? startDate : new Date(0);
        endDate = (endDate != null) ? endDate : new Date();

        Pageable pageable = PageRequest.of(page, size);

        Page<Event> eventsPage = this.repository.findFilterEvent(title, city, uf, startDate, endDate, pageable);
        return eventsPage.map(event -> new EventResponseDTO(event.getId(),
                        event.getTitulo(),
                        event.getDescricao(),
                        event.getDate(),
                        event.getRemote(),
                        event.getAddress() != null ? event.getAddress().getCity() : "",
                        event.getAddress() != null ? event.getAddress().getUf() : ""
                ))
                .stream().toList();
    }

}
