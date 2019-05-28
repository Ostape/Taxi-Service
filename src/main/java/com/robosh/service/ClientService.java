package com.robosh.service;

import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.dao.ClientDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Client;

import java.util.List;

public class ClientService {
    private DaoFactory daoFactory = DaoFactory.getInstance();


    public boolean isClientAlreadyExist(String phoneNumber, String password){
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.isClientExists(phoneNumber, password);
        }
    }

    public Client getClientById(long id){
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.getById(id);
        }
    }

    public boolean isPhoneNumberAlreadyExists(String phoneNumber){
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.isPhoneNumberExists(phoneNumber);
        }
    }

    public boolean isEmailAlreadyExists(String email){
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.isEmailExists(email);
        }
    }

    public void createClientInDatabase(Client client) throws EmailIsAlreadyTaken, PhoneNumberIsAlreadyTaken {
        try (ClientDao dao = daoFactory.createClientDao()) {
            boolean isTakenEmail = dao.isEmailExists(client.getEmail());
            boolean isTakenPhoneNumber = dao.isPhoneNumberExists(client.getPhoneNumber());
            if (isTakenEmail){
                throw new EmailIsAlreadyTaken("This email is already registered");
            }
            if (isTakenPhoneNumber){
                throw new PhoneNumberIsAlreadyTaken("This phone number is already registered");
            }
            dao.create(client);
        }
    }

    public Client getClientByPasswordAndPhone(String phoneNumber, String password){
        try(ClientDao dao = daoFactory.createClientDao()){
            return dao.getClientByPassPhone(phoneNumber, password);
        }
    }

    public List<Client> getAllClients(){
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.findAll();
        }
    }
}
