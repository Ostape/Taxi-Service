package com.robosh.service;

import com.robosh.model.dao.interfaces.AddressDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Address;
import org.apache.log4j.Logger;

import java.util.List;

public class AdressService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(AdressService.class);

    public boolean checkAddressExist(String street, String number_house){
        try (AddressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Address DAO");
            return dao.checkAddressExist(street, number_house);
        }
    }

    public Address getAddressById(long id){
        try (AddressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Address DAO");
            return dao.getById(id);
        }
    }

    public List<Address> getAllAddress(){
        try (AddressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Address DAO");
            return dao.findAll();
        }
    }

    public long getAdressId(String street, String houseNumber){
        try (AddressDao dao = daoFactory.createAdressDao()){
            LOG.debug("created Address DAO");
            return dao.getAddressId(street, houseNumber);
        }
    }

    public Address getAdressByAdressString(String addressString){
        int indexWhitespace = addressString.lastIndexOf(" ");
        String street = addressString.substring(0, indexWhitespace);
        String houseNumber = addressString.substring(indexWhitespace+1);
        try (AddressDao dao = daoFactory.createAdressDao()) {
            LOG.debug("created Address DAO");
            return dao.getAddressByStreetNumberHouse(street, houseNumber);
        }
    }
}
