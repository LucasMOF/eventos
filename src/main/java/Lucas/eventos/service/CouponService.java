package Lucas.eventos.service;

import Lucas.eventos.model.Coupon;
import Lucas.eventos.model.Event;
import Lucas.eventos.model.dto.CouponRequestDTO;
import Lucas.eventos.repository.CouponRepository;
import Lucas.eventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon createCoupon(UUID eventId, CouponRequestDTO dto){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado!"));

        Coupon coupon = new Coupon();
        coupon.setCode(dto.code());
        coupon.setDiscount(dto.discount());
        coupon.setValid(dto.valid());
        coupon.setEvent(event);

        return couponRepository.save(coupon);

    }
}
