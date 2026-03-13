package Lucas.eventos.controller;

import Lucas.eventos.model.Coupon;
import Lucas.eventos.model.dto.CouponRequestDTO;
import Lucas.eventos.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/{eventId}")
    public ResponseEntity create(@PathVariable UUID eventId, @RequestBody CouponRequestDTO body){
        Coupon coupon = this.couponService.createCoupon(eventId, body);
        return ResponseEntity.ok(coupon);
    }
}
