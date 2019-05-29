package com.robosh;

import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.Order;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main{

    public static void main(String[] args) throws PhoneNumberIsAlreadyTaken, EmailIsAlreadyTaken {
        ClientService clientService = new ClientService();

        Client client = new Client();
        client.setName("Галушка");
        client.setSurname("Галушкон");
        client.setPhoneNumber("+380956323431");

        client.setEmail("petrtfsdf@gmail.com");
        client.setPassword("passweoasd12");


        clientService.createClientInDatabase(client);

    }

}