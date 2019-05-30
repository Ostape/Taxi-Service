package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.CouponDao;
import com.robosh.model.dao.implementations.queries.CouponSQL;
import com.robosh.model.dao.mappers.CouponMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Coupon;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCouponDao implements CouponDao {
    private Connection connection;
    private static final Logger LOG = Logger.getLogger(JdbcCouponDao.class);

    public JdbcCouponDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Coupon getById(long id) {
        Mapper<Coupon> couponMapper = new CouponMapper();
        Coupon result = new Coupon();
        result.setIdCoupon(-1);

        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CouponSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Coupon> findAll() {
        List<Coupon> coupons = new ArrayList<>();
        final String query = CouponSQL.READ_ALL.getQUERY();
        LOG.debug("Executed query" + CouponSQL.READ_ALL);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Coupon> couponMapper = new CouponMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Coupon coupon = couponMapper.getEntity(rs);
                coupons.add(coupon);
            }
            return coupons;
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Coupon readByCouponName(String couponName) {
        Mapper<Coupon> couponMapper = new CouponMapper();
        Coupon result = new Coupon();
        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_COUPON.getQUERY())) {
            ps.setString(1, couponName);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CouponSQL.READ_BY_COUPON);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * not using
     *
     * @param entity
     */
    @Override
    public void create(Coupon entity) {
    }


    /**
     * not using
     *
     * @param coupon
     */
    @Override
    public boolean update(Coupon coupon) {
        return false;
    }

    /**
     * not using
     *
     * @param id
     */
    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public void close() {
        try {
            connection.close();
            LOG.debug("Connection closed");
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            throw new RuntimeException(e);
        }
    }

}
