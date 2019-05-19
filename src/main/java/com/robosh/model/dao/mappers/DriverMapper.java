package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Car;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.DriverStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverMapper implements Mapper<Driver> {
    @Override
    public Driver getEntity(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setUserId(resultSet.getInt("id_driver"));
        driver.setSurname(resultSet.getString("surname"));
        driver.setName(resultSet.getString("name"));
        driver.setMiddleName(resultSet.getString("middle_name"));
        driver.setPassword(resultSet.getString("password"));
        driver.setPhoneNumber(resultSet.getString("phone_number"));
        driver.setDriverStatus(toDriverStatus(resultSet.getString("driver_status")));
        driver.setCar();
        return null;
    }

    private DriverStatus toDriverStatus(String status){
        if (DriverStatus.BOOKED.toString()
                .equalsIgnoreCase(status)){
            return DriverStatus.BOOKED;
        }
        else {
            return DriverStatus.FREE;
        }
    }

    private Car takeCar(int id_car){
        return
    }
}
