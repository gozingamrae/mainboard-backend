package com.gozin.mainboard.coupon.service;

import com.gozin.mainboard.coupon.dao.CouponMapper;
import com.gozin.mainboard.coupon.dto.CouponDTO;
import com.gozin.mainboard.coupon.dto.SearchCouponDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponService {

    private final CouponMapper couponMapper;

    public CouponService(CouponMapper couponMapper){
        this.couponMapper = couponMapper;
    }


    @Transactional
    public CouponDTO couponInsert(CouponDTO couponDTO) {

        System.out.println("coupon insert service");

        int result = couponMapper.insertCoupon(couponDTO);
        return couponDTO;
    }

    @Transactional
    public CouponDTO couponSearch(SearchCouponDTO searchCouponDTO){
        System.out.println("coupon search service");
        CouponDTO couponDTO;
        couponDTO = couponMapper.searchCoupon(searchCouponDTO);
        return couponDTO;
    }

    @Transactional
    public CouponDTO couponDelete(CouponDTO couponCode) {
        System.out.println("coupon delete service");

        int result = couponMapper.deleteCoupon(couponCode);
        return couponCode;
    }
}
