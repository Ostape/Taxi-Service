package com.robosh.service;

import com.robosh.model.dao.CarDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Car;

import java.util.List;

public class CarService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public Car getCarById(long id){
        try (CarDao dao = daoFactory.createCarDao()) {
            return dao.getById(id);
        }
    }

    public List<Car> getAllCars(){
        try(CarDao dao = daoFactory.createCarDao()){
            return dao.findAll();
        }
    }

    public boolean findCarByIdAndCarType(int id_car, String type){
        try (CarDao dao = daoFactory.createCarDao()) {
            return dao.isSameCarType(id_car, type);
        }
    }

    public Car getCarByType(String type){
        try(CarDao dao = daoFactory.createCarDao()){
            return dao.getCarByType(type);
        }
    }
}
