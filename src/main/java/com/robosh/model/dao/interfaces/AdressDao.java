package com.robosh.model.dao.interfaces;

import com.robosh.model.entity.Adress;

public interface AdressDao extends Dao<Adress> {
    boolean checkAdressExist(String street, String number_house);
}
