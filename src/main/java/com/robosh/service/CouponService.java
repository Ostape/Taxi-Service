package com.robosh.service;

import com.robosh.model.dao.CouponDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Coupon;

import java.util.List;

public class CouponService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Coupon getCouponById(long id) {
        try (CouponDao dao = daoFactory.createCouponDao()) {
            return dao.getById(id);
        }
    }

    public List<Coupon> getAllCoupons() {
        try (CouponDao dao = daoFactory.createCouponDao()){
            return dao.findAll();
        }
    }

    public Coupon getCouponByName(String couponName){
        try (CouponDao dao = daoFactory.createCouponDao()) {
            return dao.readByCouponName(couponName);
        }
    }
}
