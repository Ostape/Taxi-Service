package com.robosh.model.dao;

import com.robosh.model.entity.Driver;

public interface DriverDao extends Dao<Driver> {
    boolean isFree();
}
