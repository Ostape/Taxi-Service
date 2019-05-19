package com.robosh.model.entity;

public class Coupon {
    private int idCoupon;
    private String couponName;

    public int getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Override
    public String toString() {
        return "CouponDao{" +
                "idCoupon=" + idCoupon +
                ", couponName='" + couponName + '\'' +
                '}';
    }
}
