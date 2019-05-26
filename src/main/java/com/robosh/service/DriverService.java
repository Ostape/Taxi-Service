package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.DriverDao;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;

import java.util.List;

public class DriverService {
    DaoFactory daoFactory = DaoFactory.getInstance();

//    public boolean isDriverIsFree(){
//
//    }

    public boolean isDriverExists(String phoneNumber, String password){
        try (DriverDao dao = daoFactory.createDriverDao()){
            return dao.isDriverExist(phoneNumber, password);
        }
    }

    public Driver getDriverByPasswordAndPhone(String phoneNumber, String password){
        try(DriverDao dao = daoFactory.createDriverDao()){
            return dao.getDriverByPassAndPhone(phoneNumber, password);
        }
    }

    public Driver getDriverById(long id) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            return dao.getById(id);
        }
    }

    public List<Driver> getAllDrivers() {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            return dao.findAll();
        }
    }

    public Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            return dao.getDriverByCarTypeAndDriverStatus(driverStatus, carType);
        }
    }

    public boolean updateDriverStatus(Driver driver) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            return dao.update(driver);
        }
    }
}
