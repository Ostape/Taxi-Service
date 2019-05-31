package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Adress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressMapper implements Mapper<Adress> {
    @Override
    public Adress getEntity(ResultSet resultSet) throws SQLException {
        Adress adress = new Adress();
        adress.setIdAdress(resultSet.getInt("id_adress"));
        adress.setStreet(resultSet.getString("street"));
        adress.setHouseNumber(resultSet.getString("house_number"));
        return adress;
    }
}
