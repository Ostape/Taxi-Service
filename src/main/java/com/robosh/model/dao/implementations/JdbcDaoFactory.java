package com.robosh.model.dao.implementations;

import com.robosh.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    @Override
    public ClientDao createClientDao() {
        return new JdbcClientDao(getConnection());
    }

    @Override
    public AdressDao createAdressDao() {
        return new JdbcAdressDao(getConnection());
    }

    @Override
    public DriverDao createDriverDao() {
        return new JdbcDriverDao(getConnection());
    }

    @Override
    public CarDao createCarDao() {
        return new JdbcCarDao(getConnection());
    }

    @Override
    public CouponDao createCouponDao() {
        return new JdbcCouponDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return null;
    }

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
