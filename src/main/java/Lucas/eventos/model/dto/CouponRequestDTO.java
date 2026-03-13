package Lucas.eventos.model.dto;

import java.util.Date;

public record CouponRequestDTO(String code, Integer discount, Date valid) {
}
