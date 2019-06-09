package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements Mapper<Address> {
    @Override
    public Address getEntity(ResultSet resultSet) throws SQLException {
        Address address = new Address();
        address.setIdAddress(resultSet.getInt("id_adress"));
        address.setStreet(resultSet.getString("street"));
        address.setHouseNumber(resultSet.getString("house_number"));
        return address;
    }
}
