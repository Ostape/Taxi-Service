package com.robosh.model.dao;

import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;

public interface DriverDao extends Dao<Driver> {
    boolean isFree();
    Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType);
    boolean isDriverExist(String phone_number, String password);
    Driver getDriverByPassAndPhone(String phone_number, String password);
}
