package com.gozin.mainboard.coupon.controller;


import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.coupon.dto.CouponDTO;
import com.gozin.mainboard.coupon.dto.SearchCouponDTO;
import com.gozin.mainboard.coupon.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> insert(@RequestBody CouponDTO coupondto){
        System.out.println(coupondto.getCouponName());
        System.out.println(coupondto.getExplanation());
        System.out.println(coupondto.getExpirationPeriod());
        System.out.println(coupondto.getMinOrderPrice());
        System.out.println(coupondto.getDiscountRate());
        System.out.println(coupondto.getTarget());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "쿠폰 등록 완료", couponService.couponInsert(coupondto)));
    }

    @PostMapping("/lists")
    public ResponseEntity<ResponseDTO> search(@RequestBody SearchCouponDTO searchCoupondto){
        System.out.println(searchCoupondto.getCouponName());
        System.out.println(searchCoupondto.getTarget());
        System.out.println(searchCoupondto.getStartDate());
        System.out.println(searchCoupondto.getEndDate());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "쿠폰 검색 완료", couponService.couponSearch(searchCoupondto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> delete(@RequestBody CouponDTO couponCode){
        System.out.println(couponCode.getCouponCode());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "쿠폰 삭제 완료", couponService.couponDelete(couponCode)));
    }
}
