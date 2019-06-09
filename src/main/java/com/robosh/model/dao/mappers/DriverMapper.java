package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.CarService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverMapper implements Mapper<Driver> {
    @Override
    public Driver getEntity(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        CarService carService = new CarService();
        driver.setPersonId(resultSet.getInt("id_driver"));
        driver.setSurname(resultSet.getString("surname"));
        driver.setName(resultSet.getString("name"));
        driver.setMiddleName(resultSet.getString("middle_name"));
        driver.setPassword(resultSet.getString("password"));
        driver.setPhoneNumber(resultSet.getString("phone_number"));
        driver.setDriverStatus(toDriverStatus(resultSet.getString("driver_status")));
        driver.setRole(Role.DRIVER);
        driver.setCar(carService.getCarById(resultSet.getInt("id_car")));
        return driver;
    }

    private DriverStatus toDriverStatus(String status) {
        if (DriverStatus.BOOKED.toString()
                .equalsIgnoreCase(status)) {
            return DriverStatus.BOOKED;
        } else {
            return DriverStatus.FREE;
        }
    }
}
