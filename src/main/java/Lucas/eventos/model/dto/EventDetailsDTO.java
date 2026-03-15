package Lucas.eventos.model.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record EventDetailsDTO(UUID id, String titulo, String descricao, Date date, boolean remote, String city, String uf, List<CouponDTO> coupons) {


public record CouponDTO(String code, Integer discount, Date valid){

}
}


