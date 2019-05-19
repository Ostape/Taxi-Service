package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements Mapper<Client> {

    @Override
    public Client getEntity(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setUserId(resultSet.getInt("id_client"));
        client.setSurname(resultSet.getString("surname"));
        client.setName(resultSet.getString("name"));
        client.setMiddleName(resultSet.getString("middle_name"));
        client.setPhoneNumber(resultSet.getString("phone_number"));
        client.setEmail(resultSet.getString("e_mail"));
        client.setPassword(resultSet.getString("password"));
        return client;
    }
}
