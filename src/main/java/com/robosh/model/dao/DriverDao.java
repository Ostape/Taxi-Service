package com.robosh.model.dao;

import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;

public interface DriverDao extends Dao<Driver> {
    boolean isFree();
    Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType);
}
