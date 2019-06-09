package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements Mapper<Client> {

    @Override
    public Client getEntity(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setPersonId(resultSet.getInt("id_client"));
        client.setSurname(resultSet.getString("surname"));
        client.setName(resultSet.getString("name"));
        client.setPhoneNumber(resultSet.getString("phone_number"));
        client.setEmail(resultSet.getString("e_mail"));
        client.setPassword(resultSet.getString("password"));
        client.setRole(Role.CLIENT);
        return client;
    }
}
