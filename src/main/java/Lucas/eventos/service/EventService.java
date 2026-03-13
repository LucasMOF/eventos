package Lucas.eventos.service;

import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event createEvent(EventRequestDTO dto) {
        Event novoEvent = new Event();

        novoEvent.setTitulo(dto.titulo());
        novoEvent.setDescricao(dto.descricao());
        novoEvent.setDate(dto.date());
        novoEvent.setRemote(dto.remote());

        return repository.save(novoEvent);

    }
}
