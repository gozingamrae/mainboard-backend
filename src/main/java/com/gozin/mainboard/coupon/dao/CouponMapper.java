package com.gozin.mainboard.coupon.dao;

import com.gozin.mainboard.coupon.dto.CouponDTO;
import com.gozin.mainboard.coupon.dto.SearchCouponDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {

    int insertCoupon(CouponDTO couponDTO);

    CouponDTO searchCoupon(SearchCouponDTO searchCouponDTO);

    int deleteCoupon(CouponDTO couponCode);
}
