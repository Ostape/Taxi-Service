package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements Mapper<Car> {
    @Override
    public Car getEntity(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setIdCar(resultSet.getInt("id_car"));
        car.setCarNumber(resultSet.getString("number"));
        car.setBrand(resultSet.getString("brand"));
        car.setColor(resultSet.getString("color"));
        car.setCarType(resultSet.getString("car_type"));
        return car;
    }
}
