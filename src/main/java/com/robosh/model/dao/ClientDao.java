package com.robosh.model.dao;

import com.robosh.model.entity.Client;

public interface ClientDao extends Dao<Client> {
    boolean isClientExists(String email, String password);

    boolean isPhoneNumberExists(String phoneNumber);

    boolean isEmailExists(String email);
}
