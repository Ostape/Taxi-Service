package com.robosh.model.dao.implementations;

import com.robosh.model.dao.CouponDao;
import com.robosh.model.dao.implementations.queries.AdressSQL;
import com.robosh.model.dao.implementations.queries.CouponSQL;
import com.robosh.model.dao.mappers.AdressMapper;
import com.robosh.model.dao.mappers.CouponMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Adress;
import com.robosh.model.entity.Coupon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCouponDao implements CouponDao {
    private Connection connection;

    public JdbcCouponDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Coupon entity) {

    }

    @Override
    public Coupon getById(long id) {
        Mapper<Coupon> couponMapper= new CouponMapper();
        Coupon result = new Coupon();
        result.setIdCoupon(-1);

        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Coupon> findAll() {
        List<Coupon> coupons = new ArrayList<>();
        final String query = CouponSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Coupon> couponMapper = new CouponMapper();

            while (rs.next()) {
                Coupon coupon = couponMapper.getEntity(rs);
                coupons.add(coupon);
            }
            return coupons;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            //todo optional
        }
    }

    @Override
    public void update(Coupon coupon) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Coupon readByCouponName(String couponName) {
        Mapper<Coupon> couponMapper= new CouponMapper();
        Coupon result = new Coupon();
        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_COUPON.getQUERY())) {
            ps.setString(1, couponName);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
