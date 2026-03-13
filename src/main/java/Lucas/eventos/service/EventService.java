package Lucas.eventos.service;

import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.repository.EventRepository;
import com.sun.jdi.request.EventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event createEvent(@RequestBody EventRequestDTO dto) {
        Event novoEvent = new Event();

        novoEvent.setTitulo(dto.titulo());
        novoEvent.setDescricao(dto.descricao());
        novoEvent.setDate(dto.date());
        novoEvent.setRemote(dto.remote());

        return repository.save(novoEvent);

    }
}
