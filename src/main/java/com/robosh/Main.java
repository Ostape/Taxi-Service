package com.robosh;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.service.ClientService;

import java.util.Scanner;

class Main{

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        Client client = new Client();

        Driver driver = new Driver();

        System.out.println(driver.getUserId());

//        String surname = "Яко";
//        String name = "Анд";
//        String phoneNumber = "+380967825532";
//        String mail = "roenko_olexandr@gmail.com";
//        String pass = "and12";
//
//        System.out.println("Hello, register please");
//
//        client.setSurname(surname);
//        client.setName(name);
//        client.setPhoneNumber(phoneNumber);
//        client.setEmail(mail);
//        client.setPassword(pass);
//        System.out.println(client);
//        try {
//            clientService.createClientInDatabase(client);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}