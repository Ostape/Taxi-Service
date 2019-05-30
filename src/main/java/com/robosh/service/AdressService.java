package com.robosh.service;

import com.robosh.model.dao.interfaces.AdressDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Adress;
import org.apache.log4j.Logger;

import java.util.List;

public class AdressService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(AdressService.class);

    public boolean checkAdressExist(String street, String number_house){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Adress DAO");
            return dao.checkAdressExist(street, number_house);
        }
    }

    public Adress getAdressById(long id){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Adress DAO");
            return dao.getById(id);
        }
    }

    public List<Adress> getAllAdress(){
        try (AdressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Adress DAO");
            return dao.findAll();
        }
    }
}
