package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Coupon;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CouponMapper implements Mapper<Coupon> {
    @Override
    public Coupon getEntity(ResultSet resultSet) throws SQLException {
        Coupon coupon = new Coupon();
        coupon.setIdCoupon(resultSet.getInt("id_coupon"));
        coupon.setCouponName(resultSet.getString("coupon_name"));
        coupon.setDiscount(resultSet.getInt("discount"));
        return coupon;
    }
}
