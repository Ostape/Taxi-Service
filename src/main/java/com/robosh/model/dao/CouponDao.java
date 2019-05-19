package com.robosh.model.dao;

import com.robosh.model.entity.Coupon;

public interface CouponDao extends Dao<Coupon> {
    Coupon readByCouponName(String couponName);
}
