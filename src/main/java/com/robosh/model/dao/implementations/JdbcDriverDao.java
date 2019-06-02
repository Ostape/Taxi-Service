package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.DriverDao;
import com.robosh.model.dao.implementations.queries.DriverSQL;
import com.robosh.model.dao.mappers.DriverMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDriverDao implements DriverDao {

    private Connection connection;
    private static final Logger LOG = Logger.getLogger(JdbcDriverDao.class);
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
            LOG.debug("Executed query" + DriverSQL.CHECK_STATUS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            LOG.debug("Executed query" + DriverSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = driverMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            LOG.debug("Executed query" + DriverSQL.READ_ALL);
            Mapper<Driver> driverMapper = new DriverMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Driver driver = driverMapper.getEntity(rs);
                drivers.add(driver);
            }
            return drivers;
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType) {
        Mapper<Driver> driverMapper = new DriverMapper();
        Driver result = null;
        try (PreparedStatement ps = connection.prepareStatement(DriverSQL
                .FIND_DRIVER_BY_CAR_TYPE_AND_STATUS.getQUERY())) {
            ps.setString(1, driverStatus.toString().toLowerCase());
            ps.setString(2, carType);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + DriverSQL.FIND_DRIVER_BY_CAR_TYPE_AND_STATUS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = new Driver();
                result = driverMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            LOG.debug("Executed query" + DriverSQL.READ_BY_PHONE_AND_PASSWORD);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            LOG.debug("Executed query" + DriverSQL.READ_BY_PHONE_AND_PASSWORD);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = driverMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            ps.execute();
            LOG.debug("Executed query" + DriverSQL.UPDATE);
            return true;
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
            LOG.debug("Connection closed");
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            throw new RuntimeException(e);
        }
    }
}
