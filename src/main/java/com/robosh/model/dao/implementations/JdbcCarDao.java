package com.robosh.model.dao.implementations;

import com.robosh.model.dao.CarDao;
import com.robosh.model.dao.implementations.queries.CarSQL;
import com.robosh.model.dao.implementations.queries.ClientSQL;
import com.robosh.model.dao.mappers.CarMapper;
import com.robosh.model.dao.mappers.ClientMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Car;
import com.robosh.model.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcCarDao implements CarDao {

    private Connection connection;

    public JdbcCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    /**
     * don`t use
     */
    public void create(Car entity) {
    }

    @Override
    public Car getById(long id) {
        Mapper<Car> carMapper = new CarMapper();
        Car result = new Car();
        result.setIdCar(-1);

        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = carMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    /**
     * don`t use
     */
    public List<Car> findAll() {
        return null;
    }

    @Override
    /**
     * don`t use
     */
    public void update(Car car) {

    }

    @Override
    /**
     * don`t use
     */
    public void delete(long id) {

    }

    @Override
    public boolean isSameCarType(int id_car, String carType) {
        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID_AND_CAR_TYPE.getQUERY())) {
            ps.setInt(1, id_car);
            ps.setString(2, carType);
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
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
