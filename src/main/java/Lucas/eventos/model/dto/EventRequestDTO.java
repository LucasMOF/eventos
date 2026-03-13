package Lucas.eventos.model.dto;

import java.util.Date;

public record EventRequestDTO(String titulo, String descricao, Date date, boolean remote, String city, String uf) {
}
