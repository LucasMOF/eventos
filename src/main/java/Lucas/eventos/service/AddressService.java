package Lucas.eventos.service;

import Lucas.eventos.model.Address;
import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.EventRequestDTO;
import Lucas.eventos.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(EventRequestDTO dto, Event event){
        Address address = new Address();
        address.setCity(dto.city());
        address.setUF(dto.uf());
        address.setEvent(event);

        return addressRepository.save(address);
    }
}
