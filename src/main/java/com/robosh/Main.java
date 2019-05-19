package com.robosh;

import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;

import java.util.Scanner;

class Main{

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        Client client = new Client();

        String surname = "Яко";
        String name = "Анд";
        String middleName = "Олекса";
        String phoneNumber = "+380967825532";
        String mail = "roenko_olexandr@gmail.com";
        String pass = "and12";

        System.out.println("Hello, register please");
       // System.out.print("Enter your Surname: ");


        client.setSurname(surname);

      //  System.out.print("Enter your Name: ");
        client.setName(name);
      //  System.out.print("Enter your middle name: ");
        client.setMiddleName(middleName);
        //System.out.print("Enter your phone number: ");
        client.setPhoneNumber(phoneNumber);
       // System.out.print("Enter your e-mail: ");
        client.setEmail(mail);
       // System.out.print("Enter Your password: ");
        client.setPassword(pass);
        System.out.println(client);
        try {
            clientService.createClientInDatabase(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}