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
        return null;
    }

    @Override
    public CarDao createCarDao() {
        return null;
    }

    @Override
    public CouponDao createCouponDao() {
        return new JdbcCouponDao(getConnection());
    }


    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
