package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DriverDao;
import com.robosh.model.dao.implementations.queries.DriverSQL;
import com.robosh.model.dao.mappers.DriverMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;

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
    public Driver getById(long id) {
        Mapper<Driver> driverMapper = new DriverMapper();
        Driver result = new Driver();
        result.setPersonId(-1);
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
                Driver driver = driverMapper.getEntity(rs);
                drivers.add(driver);
            }
            return drivers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType) {
        Mapper<Driver> driverMapper = new DriverMapper();
        Driver result = new Driver();
        result.setPersonId(-1);
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL
                .FIND_DRIVER_BY_CAR_TYPE_AND_STATUS.getQUERY())) {
            ps.setString(1, driverStatus.toString().toLowerCase());
            ps.setString(2, carType);
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
    public boolean isDriverExist(String phoneNumber, String password) {
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL.READ_BY_PHONE_AND_PASSWORD.getQUERY())) {
            ps.setString(1, phoneNumber);
            ps.setString(2, password);
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
    public Driver getDriverByPassAndPhone(String phone_number, String password) {
        Mapper<Driver> driverMapper = new DriverMapper();
        Driver result = new Driver();
        result.setPersonId(-1);
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL
                .READ_BY_PHONE_AND_PASSWORD.getQUERY())) {
            ps.setString(1, phone_number);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = driverMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * rewrite
     * @param driver
     * @return
     */
    @Override
    public boolean update(Driver driver) {
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL.UPDATE.getQUERY())) {
            ps.setString(1,driver.getDriverStatus().toString().toLowerCase());
            ps.setLong(2, driver.getPersonId());
            final ResultSet rs = ps.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * not using
     *
     * @param entity
     */
    @Override
    public void create(Driver entity) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
