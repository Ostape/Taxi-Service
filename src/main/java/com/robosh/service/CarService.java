package com.robosh.service;

import com.robosh.model.dao.CarDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Car;

public class CarService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public Car getCarById(long id){
        try (CarDao dao = daoFactory.createCarDao()) {
            return dao.getById(id);
        }
    }

    public boolean isSuchType(int id_car, String type){
        try (CarDao dao = daoFactory.createCarDao()) {
            return dao.isSameCarType(id_car, type);
        }
    }
}
