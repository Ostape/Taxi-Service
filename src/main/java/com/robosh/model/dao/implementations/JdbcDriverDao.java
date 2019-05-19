package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DriverDao;
import com.robosh.model.dao.implementations.queries.ClientSQL;
import com.robosh.model.dao.implementations.queries.DriverSQL;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.DriverStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDriverDao implements DriverDao {

    private Connection connection;

    @Override
    public boolean isFree(DriverStatus driverStatus) {
//        try (PreparedStatement ps = connection.prepareStatement(DriverSQL.READ_BY_EMAIL_PASSWORD.getQUERY())) {
//            ps.setString(1, email);
//            ps.setString(2, password);
//            final ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    @Override
    public void create(Driver entity) {

    }

    @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {

    }
}
