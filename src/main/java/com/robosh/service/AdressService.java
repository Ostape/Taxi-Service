package com.robosh.service;

import com.robosh.model.dao.AdressDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Adress;

import java.util.List;

public class AdressService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public boolean checkAdressExist(String street, String number_house){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            return dao.checkAdressExist(street, number_house);
        }
    }

    public Adress getAdressById(long id){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            return dao.getById(id);
        }
    }

    public List<Adress> getAllAdress(){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            return dao.findAll();
        }
    }
}
