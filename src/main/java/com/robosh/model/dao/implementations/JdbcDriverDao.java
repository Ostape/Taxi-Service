package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DriverDao;
import com.robosh.model.dao.implementations.queries.DriverSQL;
import com.robosh.model.dao.mappers.DriverMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.DriverStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDriverDao implements DriverDao {

    private Connection connection;

    public JdbcDriverDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    /**
     * rewrite
     */
    public boolean isFree() {
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL.CHECK_STATUS.getQUERY())) {
            ps.setString(1, DriverStatus.FREE.toString().toLowerCase());
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void create(Driver entity) {
    }

    @Override
    public Driver getById(long id) {
        Mapper<Driver> driverMapper = new DriverMapper();
        Driver result = new Driver();
        result.setUserId(-1);
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = driverMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = new ArrayList<>();
        final String query = DriverSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Driver> driverMapper = new DriverMapper();

            while (rs.next()) {
                Driver adress = driverMapper.getEntity(rs);
                drivers.add(adress);
            }
            return drivers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            //todo optional
        }
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
