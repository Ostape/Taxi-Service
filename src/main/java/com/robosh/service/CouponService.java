package com.robosh.service;

import com.robosh.model.dao.CouponDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Coupon;

public class CouponService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Coupon getCarById(long id){
        try (CouponDao dao = daoFactory.createCouponDao()) {
            return dao.getById(id);
        }
    }

    public boolean couponExists(String couponName){
        return false;
    }
}
