package com.robosh.model.dao;

import com.robosh.model.entity.Driver;
import com.robosh.model.entity.DriverStatus;

public interface DriverDao extends Dao<Driver> {
    boolean isFree(DriverStatus driverStatus);
}
