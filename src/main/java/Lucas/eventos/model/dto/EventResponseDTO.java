package Lucas.eventos.model.dto;

import java.util.Date;
import java.util.UUID;

public record EventResponseDTO(UUID id, String titulo, String descricao, Date date, boolean remote, String city, String uf) {
}
