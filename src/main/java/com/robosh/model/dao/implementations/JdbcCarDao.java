package com.robosh.model.dao.implementations;

import com.robosh.model.dao.CarDao;
import com.robosh.model.dao.implementations.queries.CarSQL;
import com.robosh.model.dao.implementations.queries.ClientSQL;
import com.robosh.model.dao.mappers.CarMapper;
import com.robosh.model.dao.mappers.ClientMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Car;
import com.robosh.model.entity.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCarDao implements CarDao {

    private static final Logger LOG = Logger.getLogger(JdbcAdressDao.class);
    private Connection connection;

    public JdbcCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Car getById(long id) {
        Mapper<Car> carMapper = new CarMapper();
        Car result = new Car();
        result.setIdCar(-1);

        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID.getQUERY())) {

            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CarSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = carMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        final String query = CarSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Car> carMapper = new CarMapper();
            LOG.debug("Executed query" + CarSQL.READ_ALL);
            while (rs.next()) {
                LOG.debug("check is rs has next");
                Car car = carMapper.getEntity(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isSameCarType(int id_car, String carType) {
        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID_AND_CAR_TYPE.getQUERY())) {
            ps.setInt(1, id_car);
            ps.setString(2, carType);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CarSQL.READ_BY_ID_AND_CAR_TYPE);
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
    public Car getCarByType(String carType) {
        Mapper<Car> carMapper = new CarMapper();
        Car result = new Car();

        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_TYPE.getQUERY())) {
            ps.setString(1, carType);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CarSQL.READ_BY_TYPE);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = carMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }


    @Override
    /**
     * don`t using
     */
    public void create(Car entity) {
    }

    @Override
    /**
     * don`t using
     */
    public boolean update(Car car) {
        return false;
    }

    @Override
    /**
     * don`t use
     */
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
